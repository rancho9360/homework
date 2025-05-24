package com.draic.homework.pojo.common;

import jakarta.validation.constraints.NotNull;
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
public class ByIdCmd {

	@NotNull(message = "id 不能为空")
	private Long id;
}
