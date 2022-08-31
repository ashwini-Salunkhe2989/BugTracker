package com.ratepay.bugtracker.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ratepay.bugtracker.Dto.BugDetailsDto;
import com.ratepay.bugtracker.service.BugCreationService;

import io.micrometer.core.annotation.Timed;

@RestController
public class BugCreationController {
	
	
	@Autowired
	private BugCreationService bugCreationService;
	
	@PostMapping("/createbug")
	@Timed(value = "createbug.time", description = "Time taken to create Bug")
	public BugDetailsDto createIncident(@RequestBody BugDetailsDto bugdetails) {
		
		BugDetailsDto bugDto = null;
		try {
			bugDto = bugCreationService.save(bugdetails);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("bugCreated"+bugDto.getAssigneeName());
		
		return bugDto;
	}


}
