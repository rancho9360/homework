package com.draic.homework.converter;

import com.draic.homework.domain.User;
import com.draic.homework.pojo.bo.UserBo;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author bkn1991
 * @date 2025/5/23 17:34
 */
@Mapper(componentModel = "spring")
public interface UserConverter {

  @BeanMapping(ignoreByDefault = true)
  @Mapping(target = "id", source = "id")
  @Mapping(target = "username", source = "username")
  @Mapping(target = "name", source = "name")
  @Mapping(target = "phoneNumber", source = "phoneNumber")
  @Mapping(target = "email", source = "email")
  UserBo user2Bo(User user);
}
