package com.draic.homework.service.impl;

import com.draic.homework.converter.TransactionConverter;
import com.draic.homework.domain.Account;
import com.draic.homework.domain.Transaction;
import com.draic.homework.pojo.bo.TransactionBo;
import com.draic.homework.pojo.command.TransactionCreateCmd;
import com.draic.homework.pojo.command.TransactionUpdateAmountCmd;
import com.draic.homework.pojo.command.TransactionUpdateDescriptionCmd;
import com.draic.homework.pojo.common.LastIdPageSizeQuery;
import com.draic.homework.repository.TransactionRepository;
import com.draic.homework.service.AccountService;
import com.draic.homework.service.TransactionService;

import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * @author bkn1991
 * @date 2025/5/24 13:23
 */
@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {

  private final TransactionRepository transactionRepository;

  @Resource private TransactionService transactionService;

  @Resource private AccountService accountService;

  @Resource private TransactionConverter transactionConverter;

  @Resource private ApplicationEventPublisher applicationEventPublisher;

  /************* 增  *************/
  @Override
  @Transactional(rollbackFor = {Exception.class})
  public TransactionBo create(TransactionCreateCmd transactionCreateCmd) throws Exception {

    Optional<Transaction> transactionOptional =
        transactionRepository.findById(transactionCreateCmd.getId());

    if (transactionOptional.isPresent()) {
      throw new Exception("id为" + transactionCreateCmd.getId() + "的交易已存在,请勿重复创建。");
    }

    Account sourceAccount;

    Account destinationAccount;

    if (transactionCreateCmd.getSourceAccountId()
        < transactionCreateCmd.getDestinationAccountId()) {
      sourceAccount = accountService.findByIdWithLock(transactionCreateCmd.getSourceAccountId());
      destinationAccount =
          accountService.findByIdWithLock(transactionCreateCmd.getDestinationAccountId());
    } else {

      destinationAccount =
          accountService.findByIdWithLock(transactionCreateCmd.getDestinationAccountId());
      sourceAccount = accountService.findByIdWithLock(transactionCreateCmd.getSourceAccountId());
    }

    if (sourceAccount.getBalance().compareTo(transactionCreateCmd.getAmount()) < 0) {
      throw new Exception("余额不足");
    }

    sourceAccount.setBalance(sourceAccount.getBalance().subtract(transactionCreateCmd.getAmount()));
    destinationAccount.setBalance(
        destinationAccount.getBalance().add(transactionCreateCmd.getAmount()));

    Transaction transaction =
        Transaction.builder()
            .amount(transactionCreateCmd.getAmount())
            .transactionDate(Instant.now())
            .sourceAccount(sourceAccount)
            .destinationAccount(destinationAccount)
            .description(transactionCreateCmd.getDescription())
            .build();

    Transaction transactionSaved = transactionRepository.save(transaction);

    return transactionConverter.transaction2TransactionBo(transactionSaved);
  }

  /************* 删  *************/
  @Override
  @Transactional(rollbackFor = {Exception.class})
  public void deleteById(Long id) {
    transactionRepository.deleteById(id);
  }

  /************* 改  *************/
  @Override
  @Transactional(rollbackFor = {Exception.class})
  public TransactionBo updateAmount(TransactionUpdateAmountCmd transactionUpdateAmountCmd) {

    return null;
  }

  @Override
  public TransactionBo updateDescription(
      TransactionUpdateDescriptionCmd transactionUpdateDescriptionCmd) throws Exception {

    Transaction transaction = transactionService.findById(transactionUpdateDescriptionCmd.getId());

    transaction.setDescription(transactionUpdateDescriptionCmd.getDescription());

    Transaction transactionSaved = transactionRepository.save(transaction);

    return transactionConverter.transaction2TransactionBo(transactionSaved);
  }

  /************* 查  *************/

  @Override
  public Transaction findById(Long id) throws Exception {
    return transactionRepository
        .findById(id)
        .orElseThrow(() -> new Exception("id为" + id + "的交易不存在"));
  }

  @Override
  public List<TransactionBo> findAll() {
    return null;
  }

  @Override
  public List<TransactionBo> findAll(LastIdPageSizeQuery lastIdPageSizeQuery) {

    Pageable pageable =
        PageRequest.of(0, lastIdPageSizeQuery.getPageSize(), Sort.by("id").ascending());
    List<Transaction> transactionList =
        transactionRepository.findNextPage(lastIdPageSizeQuery.getLastId(), pageable);
    return transactionList.stream().map(transactionConverter::transaction2TransactionBo).toList();
  }
}
