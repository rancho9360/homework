package com.draic.homework.service;

import com.draic.homework.domain.Transaction;
import com.draic.homework.pojo.bo.TransactionBo;
import com.draic.homework.pojo.command.TransactionCreateCmd;
import com.draic.homework.pojo.command.TransactionUpdateAmountCmd;
import com.draic.homework.pojo.command.TransactionUpdateDescriptionCmd;
import com.draic.homework.pojo.common.LastIdPageSizeQuery;

import java.util.List;

/**
 * @author bkn1991
 * @date 2025/5/24 12:01
 */
public interface TransactionService {

  /************* 增  *************/
  TransactionBo create(TransactionCreateCmd transactionCreateCmd) throws Exception;

  /************* 删  *************/

  void deleteById(Long id);

  /************* 改  *************/
  TransactionBo updateAmount(TransactionUpdateAmountCmd transactionUpdateAmountCmd);

  TransactionBo updateDescription(TransactionUpdateDescriptionCmd transactionUpdateDescriptionCmd) throws Exception;

  /************* 查  *************/

  Transaction findById(Long id) throws Exception;

  List<TransactionBo> findAll();

  List<TransactionBo> findAll(LastIdPageSizeQuery lastIdPageSizeQuery);
}
