package com.draic.homework.repository;

import com.draic.homework.pojo.po.StudentPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPoRepository extends JpaRepository<StudentPo, Long> {
  }