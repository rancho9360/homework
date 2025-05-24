package com.draic.homework.service.impl;

import com.draic.homework.domain.Account;
import com.draic.homework.repository.AccountRepository;
import com.draic.homework.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author bkn1991
 * @date 2025/5/24 13:59
 */
@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

  /************* 增  *************/
  /************* 刪  *************/
  /************* 改  *************/
  /************* 查  *************/

  private final AccountRepository accountRepository;

  @Override
  public Account findById(Long id) throws Exception {
    return accountRepository.findById(id).orElseThrow(() -> new Exception("id为" + id + "的账户不存在"));
  }

  @Override
  @Transactional(readOnly = false) // 覆盖为读写事务
  public Account findByIdWithLock(Long id) throws Exception {
    return accountRepository.findByIdWithLock(id).orElseThrow(() -> new IllegalArgumentException("账户不存在"));
  }

  /************* 业务  *************/

}
