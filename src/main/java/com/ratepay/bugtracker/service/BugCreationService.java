package com.ratepay.bugtracker.service;

import java.text.ParseException;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratepay.bugtracker.Dto.BugDetailsDto;
import com.ratepay.bugtracker.model.BugDetails;
import com.ratepay.bugtracker.repository.BugCreationRepository;

@Service
public class BugCreationService {
	
	@Autowired
	private BugCreationRepository bugCreationRepository;

	 @Autowired
	 private ModelMapper modelMapper ;
	    
	public BugDetailsDto save(BugDetailsDto bugdetails) throws ParseException {
		
		BugDetails bug = convertToEntity(bugdetails);
		
		BugDetails details=	bugCreationRepository.save(bug);
		BugDetailsDto detailsDto=converttoDto(details);
		return detailsDto;
	}
	

	private BugDetails convertToEntity(BugDetailsDto bugDto) throws ParseException {
		BugDetails post = modelMapper.map(bugDto, BugDetails.class);
	      
	    return post;
	}
	
	private BugDetailsDto converttoDto(BugDetails bugdetails) throws ParseException {
	   
	BugDetailsDto post = modelMapper.map(bugdetails, BugDetailsDto.class);
	      
	    return post;
	}
}
