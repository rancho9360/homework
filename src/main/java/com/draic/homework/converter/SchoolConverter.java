package com.draic.homework.converter;

import com.draic.homework.domain.School;
import com.draic.homework.pojo.bo.SchoolBo;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author huishixing
 * @date 2025/7/30 16:08
 */

@Mapper(componentModel = "spring")
public interface SchoolConverter {

	@BeanMapping(ignoreByDefault = true)
	@Mapping(target = "id", source = "id")
	@Mapping(target = "code", source = "code")
	@Mapping(target = "name", source = "name")
	SchoolBo school2SchoolBo(School school);
}