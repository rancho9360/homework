package com.draic.homework.pojo.command;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 修改交易金额
 *
 * @author bkn1991
 * @date 2025/5/24 12:07
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionUpdateDescriptionCmd {
  @NotNull(message = "交易id不能为空")
  private Long id;

  private String description;
}
