package com.rhc.automation.service;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rhc.automation.model.OpenShiftCluster;

public interface OpenShiftClusterRepository extends PagingAndSortingRepository<OpenShiftCluster, Long>{

}
