package com.draic.homework.pojo.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author bkn1991
 * @date 2025/5/24 12:04
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDeletedCmd {

	private Long id;
}
