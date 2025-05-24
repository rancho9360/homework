package com.draic.homework.controller;

import com.draic.homework.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author bkn1991
 * @date 2025/5/24 19:35
 */
@WebMvcTest(TransactionController.class)
public class TransactionControllerTest {

  @Autowired private MockMvc mockMvc;

  @Mock private TransactionService transactionService;

  @Test
  void createTest() throws Exception {
    // 准备数据
    //		User mockUser = new User(1L, "Alice", 25);
    //
    //		TransactionBo.builder().
    //
    //		when(transactionService.create(transactionCreateCmd)).thenReturn(mockUser);
    //
    //		// 执行HTTP请求
    //		mockMvc.perform(get("/api/users/{id}", 1L))
    //				.andExpect(status().isOk())
    //				.andExpect(jsonPath("$.name").value("Alice"))
    //				.andExpect(jsonPath("$.age").value(25));
  }
}
