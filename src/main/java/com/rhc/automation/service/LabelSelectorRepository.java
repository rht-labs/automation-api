package com.rhc.automation.service;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rhc.automation.model.LabelSelector;

public interface LabelSelectorRepository extends PagingAndSortingRepository<LabelSelector, Long> {

}
