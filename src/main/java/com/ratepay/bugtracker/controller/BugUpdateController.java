package com.ratepay.bugtracker.controller;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ratepay.bugtracker.Dto.BugDetailsDto;
import com.ratepay.bugtracker.service.BugUpdationService;

import io.micrometer.core.annotation.Timed;

@RestController
public class BugUpdateController {
	@Autowired
	private BugUpdationService bugUpdationService;
	Logger logger = LoggerFactory.getLogger(BugUpdateController.class);
	
	@PostMapping("/updatebug")
	@Timed(value = "updatebug.time", description = "Time taken to update bug")
	public BugDetailsDto updateBugDetails(@RequestBody BugDetailsDto bugDetails) {
		
		BugDetailsDto updatedBug = null;
		try {
			updatedBug = bugUpdationService.save(bugDetails);
		} catch (ParseException e) {
			logger.error(e.getMessage());
			
		}
		
		
		return updatedBug;


	}

}
