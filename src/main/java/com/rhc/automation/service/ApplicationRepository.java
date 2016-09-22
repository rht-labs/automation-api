package com.rhc.automation.service;

import com.rhc.automation.model.Application;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ApplicationRepository extends PagingAndSortingRepository<Application, Long>{

}
