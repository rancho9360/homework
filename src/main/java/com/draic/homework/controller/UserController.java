package com.draic.homework.controller;

import com.draic.homework.common.Result;
import com.draic.homework.pojo.bo.UserBo;
import com.draic.homework.pojo.command.UserCreateCmd;
import com.draic.homework.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  @PostMapping("/create")
  public Result<UserBo> create(@RequestBody UserCreateCmd userCreateCmd) throws Exception {
    UserBo userBo = userService.createUser(userCreateCmd);
    return Result.success("用户创建成功", userBo);
  }
}
