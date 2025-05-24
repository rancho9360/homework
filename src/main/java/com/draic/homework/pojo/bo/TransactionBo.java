package com.draic.homework.pojo.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * @author bkn1991
 * @date 2025/5/24 12:53
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionBo {

  private Long id;

  private BigDecimal amount;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
  private Instant transactionDate;

  private AccountBo sourceAccount;

  private AccountBo destinationAccount;

  private String description;
}
