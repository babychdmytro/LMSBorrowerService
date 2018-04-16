package com.gcit.lms.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gcit.lms.entity.BookLoan;

@Repository
public interface BookLoansRepository extends JpaRepository<BookLoan, Integer> {
	
	@Query("SELECT bl FROM BookLoan bl where bl.cardNo = ?1")
    public List<BookLoan> findBookLoansByCardNo(Integer cardNo);
	
	@Query("SELECT bl FROM BookLoan bl where bl.cardNo = ?1 and dateIn is null")
    public List<BookLoan> findBorrowedBookLoansByCardNo(Integer cardNo);
	
	@Query("SELECT bl FROM BookLoan bl where bl.dateIn is null")
    public List<BookLoan> findNotReturnedBookLoans();
	
	@Query("SELECT bl FROM BookLoan bl where bl.branch.branchId = ?1 AND bl.cardNo = ?2 AND bl.book.bookId = ?3 AND bl.dateOut = ?4")
    public BookLoan findBookLoanByDetails(Integer branchId, Integer cardNo, Integer bookId, Date dateOut);
	
}
