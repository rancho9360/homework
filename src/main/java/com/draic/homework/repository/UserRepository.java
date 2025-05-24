package com.draic.homework.repository;


import com.draic.homework.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // 自定义查询方法（根据 email 查找用户）
    Optional<User> findByEmail(String email);
}