package com.draic.homework.service.impl;

import com.draic.homework.common.IdGenerator;
import com.draic.homework.converter.StudentConverter;
import com.draic.homework.domain.Room;
import com.draic.homework.domain.Student;
import com.draic.homework.pojo.bo.StudentBo;
import com.draic.homework.pojo.command.StudentCreateCmd;
import com.draic.homework.pojo.po.StudentPo;
import com.draic.homework.repository.StudentPoRepository;
import com.draic.homework.repository.StudentRepository;
import com.draic.homework.service.RoomService;
import com.draic.homework.service.StudentService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huishixing
 * @date 2025/7/30 15:42
 */
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;

	private final StudentPoRepository studentPoRepository;

	private final StudentConverter studentConverter;


	@Resource
	private RoomService roomService;

	@Override
	public StudentBo create(StudentCreateCmd studentCreateCmd) {


//		StudentPo studentPo = StudentPo.builder()
//				.id(IdGenerator.snowFlakeUtil.nextId())
//				.code(studentCreateCmd.getCode())
//				.name(studentCreateCmd.getName())
//				.remark(studentCreateCmd.getRemark())
//				.roomId(studentCreateCmd.getRoomId())
//				.build();
//
//		StudentPo studentPoSaved = studentPoRepository.save(studentPo);
//
//		return  studentConverter.studentPo2StudentBo(studentPoSaved);


		Room room = roomService.findById(studentCreateCmd.getRoomId());

		Student student= Student.builder()
				.id(1L)
				.code(studentCreateCmd.getCode())
				.name(studentCreateCmd.getName())
				.room(room)
				.remark(studentCreateCmd.getRemark())
				.build();

		Student studentSaved = studentRepository.save(student);

		List<String> collected = studentSaved.getRoom().getStudents().stream().map(Student::getName).collect(Collectors.toList());


		return studentConverter.student2StudentBo(studentSaved);
	}
}
