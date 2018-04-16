package com.gcit.lms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gcit.lms.entity.Borrower;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Integer> {

	Optional<Borrower> findBorrowerByCardNo(Integer cardNo);
	
}
