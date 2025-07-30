package com.draic.homework.converter;

import com.draic.homework.domain.Student;
import com.draic.homework.domain.User;
import com.draic.homework.pojo.bo.StudentBo;
import com.draic.homework.pojo.bo.UserBo;
import com.draic.homework.pojo.po.StudentPo;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author huishixing
 * @date 2025/7/30 16:08
 */

@Mapper(componentModel = "spring",uses = {UserConverter.class})
public interface StudentConverter {

	@BeanMapping(ignoreByDefault = true)
	@Mapping(target = "id", source = "id")
	@Mapping(target = "name", source = "name")
	StudentBo student2StudentBo(Student student);


	@BeanMapping(ignoreByDefault = true)
	@Mapping(target = "id", source = "id")
	@Mapping(target = "name", source = "name")
	StudentBo studentPo2StudentBo(StudentPo studentPo);
}
