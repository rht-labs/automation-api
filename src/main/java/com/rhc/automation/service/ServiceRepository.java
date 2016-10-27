package com.rhc.automation.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.rhc.automation.model.Service;

public interface ServiceRepository extends PagingAndSortingRepository<Service, Long>, QueryByExampleExecutor<Service> {

}
