package com.ratepay.bugtracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ratepay.bugtracker.model.BugDetails;
import com.ratepay.bugtracker.repository.BugCreationRepository;

import io.micrometer.core.annotation.Timed;

@RestController
public class BugCreationController {
	
	
	@Autowired
	private BugCreationRepository bugCreationRepository;
	
	@PostMapping("/createbug")
	@Timed(value = "createbug.time", description = "Time taken to create Bug")
	public BugDetails createIncident(@RequestBody BugDetails bugdetails) {
		
		BugDetails bugCreated=bugCreationRepository.save(bugdetails);
		System.out.println("bugCreated"+bugCreated.getAssignee());
		
		return bugCreated;
	}


}
