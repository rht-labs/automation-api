package com.rhc.automation.service;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rhc.automation.model.PersistentVolumeClaim;

public interface PersistentVolumeClaimRepository extends PagingAndSortingRepository<PersistentVolumeClaim, Long>{

}
