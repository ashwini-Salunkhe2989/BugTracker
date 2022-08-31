package com.ratepay.bugtracker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
		System.out.println("bugdetails"+bugDetails.toString());
		
		return bugDetails;

	}

	@GetMapping("/bugdetailsbyassignee/{assignee}")
	@Timed(value = "bugdetailsbyassignee.time", description = "Time taken to give bug by assignee")
	public List<BugDetails> getBugDetailsByAssignee(@PathVariable String assignee) {
		
		List<BugDetails> bugDetails = bugDetailsRepository.findByAssignee(assignee);
		System.out.println("bugdetails"+bugDetails.toString());
		
		return bugDetails;


	}


}
