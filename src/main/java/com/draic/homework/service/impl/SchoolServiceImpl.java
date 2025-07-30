package com.draic.homework.service.impl;

import com.draic.homework.common.IdGenerator;
import com.draic.homework.converter.SchoolConverter;
import com.draic.homework.domain.School;
import com.draic.homework.pojo.bo.SchoolBo;
import com.draic.homework.pojo.command.SchoolCreateCmd;
import com.draic.homework.repository.SchoolRepository;
import com.draic.homework.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author huishixing
 * @date 2025/7/30 15:42
 */
@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

	private final SchoolRepository schoolRepository;

	private final SchoolConverter schoolConverter;

	@Override
	public SchoolBo create(SchoolCreateCmd schoolCreateCmd) {

		School school = School.builder()
				.id(IdGenerator.snowFlakeUtil.nextId())
				.code(schoolCreateCmd.getCode())
				.name(schoolCreateCmd.getName())
				.build();

		School schoolSaved = schoolRepository.save(school);

		return schoolConverter.school2SchoolBo(schoolSaved);
	}
}