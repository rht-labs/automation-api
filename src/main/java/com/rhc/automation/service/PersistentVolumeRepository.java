package com.rhc.automation.service;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rhc.automation.model.PersistentVolume;

public interface PersistentVolumeRepository extends PagingAndSortingRepository<PersistentVolume, Long>{

}
