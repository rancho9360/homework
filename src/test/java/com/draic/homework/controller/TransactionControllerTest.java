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

  }
}
