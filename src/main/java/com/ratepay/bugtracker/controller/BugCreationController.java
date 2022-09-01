package com.ratepay.bugtracker.controller;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ratepay.bugtracker.Dto.BugDetailsDto;
import com.ratepay.bugtracker.service.BugCreationService;

import io.micrometer.core.annotation.Timed;

@RestController
/**
 * 
 * @author ashwini
 * This class contains request mapping to create bug with minimum details
 *
 */
public class BugCreationController {
	
	
	@Autowired
	private BugCreationService bugCreationService;
	Logger logger = LoggerFactory.getLogger(BugCreationController.class);
	
	@PostMapping("/createbug")
	@Timed(value = "createbug.time", description = "Time taken to create Bug")
	public BugDetailsDto createIncident(@RequestBody BugDetailsDto bugdetails) {
		
		BugDetailsDto bugDto = null;
		try {
			bugDto = bugCreationService.save(bugdetails);
		} catch (ParseException e) {
			logger.error(e.getMessage());
		}
				
		return bugDto;
	}


}
