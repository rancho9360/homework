package com.draic.homework.service.impl;


import com.draic.homework.common.IdGenerator;
import com.draic.homework.converter.UserConverter;
import com.draic.homework.domain.User;
import com.draic.homework.pojo.bo.UserBo;
import com.draic.homework.pojo.command.UserCreateCmd;
import com.draic.homework.repository.UserRepository;
import com.draic.homework.service.UserService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Resource
    private UserConverter userConverter;


    /**
     * 创建用户
     *
     * @param userCreateCmd
     */
    @Override
    public UserBo createUser(UserCreateCmd userCreateCmd) {

        User user = User.builder()
                .id(IdGenerator.snowFlakeUtil.nextId())
                .username(userCreateCmd.getUsername())
                .email(userCreateCmd.getEmail())
                .build();

        User save = userRepository.save(user);

        return userConverter.user2Bo(save);
    }
}