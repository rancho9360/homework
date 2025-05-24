package com.draic.homework.pojo.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 修改交易金额
 * @author bkn1991
 * @date 2025/5/24 12:07
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionUpdateAmountCmd {
	private Long id;

	/**
	 *
	* */
	private BigDecimal amount;
}
