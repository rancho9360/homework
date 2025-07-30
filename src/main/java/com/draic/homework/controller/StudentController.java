package com.draic.homework.controller;

import com.draic.homework.common.Result;
import com.draic.homework.pojo.bo.StudentBo;
import com.draic.homework.pojo.bo.UserBo;
import com.draic.homework.pojo.command.StudentCreateCmd;
import com.draic.homework.pojo.command.UserCreateCmd;
import com.draic.homework.service.StudentService;
import com.draic.homework.service.UserService;
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
@RequestMapping("/student")
public class StudentController {

	private final StudentService studentService;

	@PostMapping("/create")
	public Result<StudentBo> create(@RequestBody StudentCreateCmd studentCreateCmd) throws Exception {
		StudentBo studentBo = studentService.create(studentCreateCmd);
		return Result.success("用户创建成功", studentBo);
	}

}
