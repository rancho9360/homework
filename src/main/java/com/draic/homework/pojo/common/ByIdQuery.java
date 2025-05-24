package com.draic.homework.pojo.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author bkn1991
 * @date 2025/5/24 12:45
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ByIdQuery {
	private Long id;
}
