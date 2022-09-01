package com.ratepay.bugtracker.service;

import java.text.ParseException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratepay.bugtracker.Dto.BugDetailsDto;
import com.ratepay.bugtracker.exception.CustomExceptionMessageGenerator;
import com.ratepay.bugtracker.model.BugDetails;
import com.ratepay.bugtracker.repository.BugUpdateRepository;

@Service
public class BugUpdationService {
	
	@Autowired
	private BugUpdateRepository bugUpdateRepository;

	 @Autowired
	 private ModelMapper modelMapper ;
	    
	public BugDetailsDto save(BugDetailsDto bugdetails) throws ParseException {
		
		BugDetails bug = convertToEntity(bugdetails);
		BugDetailsDto detailsDto;
		Optional<BugDetails> oldbugdetail= bugUpdateRepository.findById(bugdetails.getBugId());
		
		if(oldbugdetail.isPresent() && oldbugdetail.get().getAssignee().equalsIgnoreCase(bugdetails.getUpdatedBy())) {
			BugDetails details=	bugUpdateRepository.save(bug);
			 detailsDto=converttoDto(details);
		}
		else {
			throw new CustomExceptionMessageGenerator("Bug Cant be updated please check details");
		}
		
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
