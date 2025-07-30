package com.draic.homework.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huishixing
 * @date 2025/7/30 15:59
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchoolBo {

	private Long id;

	private String code;

	private String name;
}