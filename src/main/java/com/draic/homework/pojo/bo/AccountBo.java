package com.draic.homework.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author bkn1991
 * @date 2025/5/24 14:45
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountBo {

	private Long id;

	private String code;

	private UserBo user;

	private BigDecimal balance;
}
