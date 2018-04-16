package com.gcit.lms.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gcit.lms.entity.Borrower;
import com.gcit.lms.repository.BorrowerRepository;

@RestController
public class BorrowerService {
	
	@Autowired
	BorrowerRepository borrowerRepository;
	
	
	//Getting all Borrowers
	@RequestMapping(value="/borrowers", method=RequestMethod.GET)
	public List<Borrower> readAllBorrowers(){
		return borrowerRepository.findAll();
	}
	
	//Getting Borrower by CardNo
	@RequestMapping(value = "borrowers/{cardNo}", method = RequestMethod.GET, produces = "application/json")
	public Optional<Borrower> getBorrowerByPk(@PathVariable("cardNo") Integer cardNo, HttpServletResponse response) throws SQLException, IOException {
		
		Optional<Borrower> borrower =  borrowerRepository.findBorrowerByCardNo(cardNo);
		
		if (borrower == null) {
			response.sendError(404, "Invalid id, Borrower does not exist in the database.");
		}
			
		return borrower;
	}
	
	//Saving Borrower
	@RequestMapping(value = "borrower", method = RequestMethod.POST, consumes = "application/json")
	public void saveBorrower(@RequestBody Borrower Borrower) throws SQLException {
		borrowerRepository.save(Borrower);
	}
	
	
	//Deleting Borrower
	@RequestMapping(value = "borrowers/{cardNo}", method = RequestMethod.DELETE)
	public void deleteBorrower(@PathVariable("cardNo") Integer cardNo, HttpServletResponse response) throws SQLException {
		
		borrowerRepository.deleteById(cardNo);

	}
	
	
	//Updating Borrower
	@RequestMapping(value = "borrowers/{cardNo}", method = RequestMethod.PUT, consumes = "application/json")
	public void updateBorrower(@RequestBody Borrower borrower, @PathVariable Integer cardNo) throws SQLException {
		
		borrower.setCardNo(cardNo);
		borrowerRepository.save(borrower);
		
	}

}
