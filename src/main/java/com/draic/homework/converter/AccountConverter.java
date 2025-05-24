package com.draic.homework.converter;

import com.draic.homework.domain.Account;
import com.draic.homework.pojo.bo.AccountBo;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author bkn1991
 * @date 2025/5/24 14:42
 */
@Mapper(componentModel = "spring",uses = {UserConverter.class})
public interface AccountConverter {

	@BeanMapping(ignoreByDefault = true)
	@Mapping(target = "id", source = "id")
	@Mapping(target = "code", source = "code")
	@Mapping(target = "user", source = "user")
	@Mapping(target = "balance", source = "balance")
	AccountBo account2AccountBo(Account account);



}
