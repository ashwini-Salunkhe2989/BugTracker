package com.ratepay.bugtracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ratepay.bugtracker.model.BugDetails;
import com.ratepay.bugtracker.repository.BugUpdateRepository;

import io.micrometer.core.annotation.Timed;

@RestController
public class BugUpdateController {
	@Autowired
	private BugUpdateRepository bugUpdateRepository;
	
	@PostMapping("/updatebug")
	@Timed(value = "updatebug.time", description = "Time taken to update bug")
	public BugDetails updateBugDetails(@RequestBody BugDetails bugDetails) {
		
		BugDetails updatedBug= bugUpdateRepository.save(bugDetails);
		System.out.println("bugUpdated"+updatedBug.getBugId());
		
		return updatedBug;


	}

}
