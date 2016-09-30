package com.rhc.automation.service;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rhc.automation.model.Engagement;

public interface EngagementRepository extends PagingAndSortingRepository<Engagement, Long>{

}
