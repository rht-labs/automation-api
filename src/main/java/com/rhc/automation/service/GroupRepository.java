package com.rhc.automation.service;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rhc.automation.model.Group;

public interface GroupRepository extends PagingAndSortingRepository<Group, Long> {

}
