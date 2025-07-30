package com.draic.homework.pojo.command;

import jakarta.validation.constraints.NotBlank;
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
public class SchoolCreateCmd {

	private String code;

	private String name;
}