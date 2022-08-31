package com.ratepay.bugtracker.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ratepay.bugtracker.model.BugDetails;


@Repository
public interface BugDetailsRepository extends CrudRepository<BugDetails, Long>  {
	
	List<BugDetails> findByAssignee(String assignee);


}
