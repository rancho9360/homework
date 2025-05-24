package com.draic.homework.converter;

import com.draic.homework.domain.Transaction;
import com.draic.homework.domain.User;
import com.draic.homework.pojo.bo.TransactionBo;
import com.draic.homework.pojo.bo.UserBo;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author bkn1991
 * @date 2025/5/24 14:42
 */
@Mapper(componentModel = "spring",  uses = {AccountConverter.class})
public interface TransactionConverter {

	@BeanMapping(ignoreByDefault = true)
	@Mapping(target = "id", source = "id")
	@Mapping(target = "amount", source = "amount")
	@Mapping(target = "transactionDate", source = "transactionDate")
	@Mapping(target = "sourceAccount", source = "sourceAccount")
	@Mapping(target = "destinationAccount", source = "destinationAccount")
	@Mapping(target = "description", source = "description")
	TransactionBo transaction2TransactionBo(Transaction transaction);

}
