package com.draic.homework.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

/**
 * @author bkn1991
 * @date 2025/5/24 20:00
 */
@DataJpaTest
public class TransactionRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private TransactionRepository transactionRepository;


}
