package com.draic.homework.pojo.command;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huishixing
 * @date 2025/7/30 15:58
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentCreateCmd {

	private String code;


	private String name;


	@Size(max = 50)
	private Long roomId;

	private String remark;
}
