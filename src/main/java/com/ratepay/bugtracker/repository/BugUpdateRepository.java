package com.ratepay.bugtracker.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ratepay.bugtracker.model.BugDetails;


@Repository
public interface BugUpdateRepository extends CrudRepository<BugDetails, Long>  {
	

}
