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

import com.gcit.lms.entity.Branch;
import com.gcit.lms.repository.BranchRepository;
import com.gcit.lms.repository.BranchRepository;

@RestController
public class BranchService {
	
	@Autowired
	BranchRepository branchRepository;
	
	
	//Getting all Branches
	@RequestMapping(value="/branches", method=RequestMethod.GET)
	public List<Branch> readAllBranches(){
		return branchRepository.findAll();
	}
	
	//Getting Branch by CardNo
	@RequestMapping(value = "branches/{branchId}", method = RequestMethod.GET, produces = "application/json")
	public Branch getBranchByPk(@PathVariable("branchId") Integer branchId, HttpServletResponse response) throws SQLException, IOException {
		
		Branch branch =  branchRepository.findByBranchId(branchId);
		
		if (branch == null) {
			response.sendError(404, "Invalid id, branch does not exist in the database.");
		}
			
		return branch;
	}
	
	//Saving Branch
	@RequestMapping(value = "branch", method = RequestMethod.POST, consumes = "application/json")
	public void saveBranch(@RequestBody Branch Branch) throws SQLException {
		branchRepository.save(Branch);
	}
	
	
	//Deleting Branch
	@RequestMapping(value = "branches/{branchId}", method = RequestMethod.DELETE)
	public void deleteBranch(@PathVariable("branchId") Integer branchId, HttpServletResponse response) throws SQLException {
		
		branchRepository.deleteById(branchId);

	}
	
	
	//Updating Branch
	@RequestMapping(value = "branches/{branchId}", method = RequestMethod.PUT, consumes = "application/json")
	public void updateBranch(@RequestBody Branch branch, @PathVariable Integer branchId) throws SQLException {
		
		branch.setBranchId(branchId);
		branchRepository.save(branch);
		
	}

}
