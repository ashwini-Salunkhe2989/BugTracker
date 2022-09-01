package com.ratepay.bugtracker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ratepay.bugtracker.exception.CustomExceptionMessageGenerator;
import com.ratepay.bugtracker.model.BugDetails;
import com.ratepay.bugtracker.repository.BugDetailsRepository;

import io.micrometer.core.annotation.Timed;

@RestController
public class BugDetailsController {

	
	@Autowired
	private BugDetailsRepository bugDetailsRepository;
	
	@GetMapping("/bugdetails/{bugid}")
	@Timed(value = "bugdetails.time", description = "Time taken to create Incident")
	public Optional<BugDetails> getBugDetails(@PathVariable Long bugid) {
		
		Optional<BugDetails> bugDetails=bugDetailsRepository.findById(bugid);
		if(bugDetails.isPresent()) {
			return bugDetails;
		}
		else {
			throw new CustomExceptionMessageGenerator("Bug Id invalid please check ID");
		}
		

	}

	@GetMapping("/bugdetailsbyassignee/{assignee}")
	@Timed(value = "bugdetailsbyassignee.time", description = "Time taken to give bug by assignee")
	public Optional<List<BugDetails> >getBugDetailsByAssignee(@PathVariable String assignee) {
		
		List<BugDetails> bugDetails = bugDetailsRepository.findByAssignee(assignee);
		
		if(!bugDetails.isEmpty()) {
			return Optional.of(bugDetails);
		}
			
		else {
			throw new CustomExceptionMessageGenerator("No Bug present for this id");
			
		}


	}


}
