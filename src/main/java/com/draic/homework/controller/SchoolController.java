package com.draic.homework.controller;

import com.draic.homework.common.Result;
import com.draic.homework.pojo.bo.SchoolBo;
import com.draic.homework.pojo.command.SchoolCreateCmd;
import com.draic.homework.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huishixing
 * @date 2025/7/30 16:11
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/school")
public class SchoolController {

	private final SchoolService schoolService;

	@PostMapping("/create")
	public Result<SchoolBo> create(@RequestBody SchoolCreateCmd schoolCreateCmd) throws Exception {
		SchoolBo schoolBo = schoolService.create(schoolCreateCmd);
		return Result.success("学校创建成功", schoolBo);
	}

}