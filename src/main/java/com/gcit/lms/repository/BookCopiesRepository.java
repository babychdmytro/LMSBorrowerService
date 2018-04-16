package com.gcit.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.BookCopies;
import com.gcit.lms.entity.BookLoan;

@Repository
public interface BookCopiesRepository extends JpaRepository<BookCopies, Integer>{

	@Query("SELECT bc FROM BookCopies bc where bc.bookId = ?1 AND bc.branchId = ?2")
    public Optional<BookCopies> findByBookIdAndBranchId(Integer bookId, Integer branchId);
	
}
