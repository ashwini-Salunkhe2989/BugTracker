package com.ratepay.bugtracker.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ratepay.bugtracker.model.BugDetails;

@Repository
public interface BugDeleteRepository extends CrudRepository<BugDetails, Long>   {

}
