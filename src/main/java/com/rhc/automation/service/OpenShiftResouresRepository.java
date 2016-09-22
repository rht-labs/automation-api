package com.rhc.automation.service;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rhc.automation.model.OpenShiftResources;

public interface OpenShiftResouresRepository extends PagingAndSortingRepository<OpenShiftResources, Long> {

}
