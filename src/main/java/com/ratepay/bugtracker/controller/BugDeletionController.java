package com.ratepay.bugtracker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratepay.bugtracker.repository.BugDeleteRepository;

import io.micrometer.core.annotation.Timed;

@RestController
public class BugDeletionController {
	
	@Autowired
	private BugDeleteRepository bugDeleteRepository;
	
	Logger logger = LoggerFactory.getLogger(BugDeletionController.class);
	
	@PostMapping("/deletebug/{bugid}")
	@Timed(value = "deletebug.time", description = "Time taken to delete Bug")
	public void deleteBugDetails(@PathVariable Long bugid) {
		
		bugDeleteRepository.deleteById(bugid);
		
	}

}
