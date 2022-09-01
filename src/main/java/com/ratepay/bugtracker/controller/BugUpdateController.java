package com.ratepay.bugtracker.controller;

import java.text.ParseException;

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
	
	@PostMapping("/updatebug")
	@Timed(value = "updatebug.time", description = "Time taken to update bug")
	public BugDetailsDto updateBugDetails(@RequestBody BugDetailsDto bugDetails) {
		
		BugDetailsDto updatedBug = null;
		try {
			updatedBug = bugUpdationService.save(bugDetails);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return updatedBug;


	}

}
