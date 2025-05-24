package com.draic.homework.service;

import com.draic.homework.pojo.bo.UserBo;
import com.draic.homework.pojo.command.UserCreateCmd;

/**
 * @author bkn1991
 * @date 2025/5/23 13:51
 */
public interface UserService {

  /** 创建用户 */
  UserBo createUser(UserCreateCmd userCreateCmd) throws Exception;
}
