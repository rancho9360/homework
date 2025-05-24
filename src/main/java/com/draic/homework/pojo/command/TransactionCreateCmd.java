package com.draic.homework.pojo.command;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 交易创建命令
 *
 * @author bkn1991
 * @date 2025/5/24 12:02
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionCreateCmd {

  /**
   * 交易id, 模拟幂等性操作
  * */
  @NotNull(message = "幂等控制的交易id不能为空")
  private Long id;

  /** 用于支付的账户 */
  @NotNull(message = "源账户id不能为空")
  private Long sourceAccountId;

  /** 目标账户 */
  @NotNull(message = "目标账户id不能为空")
  private Long destinationAccountId;

  /** 金额 */
  @NotNull(message = "交易金额不能为空")
  @DecimalMin(value = "0.01", message = "交易金额必须大于0")
  private BigDecimal amount;

  /** 交易描述 */
  private String description;
}
