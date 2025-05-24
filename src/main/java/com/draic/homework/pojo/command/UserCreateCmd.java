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
 * @author bkn1991
 * @date 2025/5/23 14:04
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateCmd {

	@Size(min = 2, max = 10, message = "名称长度必须在2到10个字符之间")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "名称只能包含大小写字母和数字")
	private String username;

	@NotBlank(message = "邮箱不能为空")
	@Email(message = "邮箱格式不正确")
	private String email;

}
