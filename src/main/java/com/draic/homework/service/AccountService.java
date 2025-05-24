package com.draic.homework.service;

import com.draic.homework.domain.Account;

/**
 * @author bkn1991
 * @date 2025/5/24 12:01
 */
public interface AccountService {
  /************* 增  *************/
  /************* 刪  *************/
  /************* 改  *************/
  /************* 查  *************/
  Account findById(Long id) throws Exception;

  Account findByIdWithLock(Long id) throws Exception;
}
