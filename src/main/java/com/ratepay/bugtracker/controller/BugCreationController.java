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
	
	@PostMapping("/createIncident")
	@Timed(value = "createIncident.time", description = "Time taken to create Incident")
	public BugDetails createIncident(@RequestBody BugDetails customer) {
		
		BugDetails incidentcreated=bugCreationRepository.save(customer);
		System.out.println("bugCreated"+incidentcreated.getAssignee());
		
		return incidentcreated;


	}


}
