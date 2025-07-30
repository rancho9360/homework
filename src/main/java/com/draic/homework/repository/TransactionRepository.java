package com.draic.homework.repository;

import com.draic.homework.domain.Transaction;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	// 按 ID 升序分页（适用于"下一页"操作）
	@Query("SELECT t FROM Transaction t WHERE t.id > :lastId ORDER BY t.id ASC")
	List<Transaction> findNextPage(@Param("lastId") Long lastId, Pageable pageable);



}
