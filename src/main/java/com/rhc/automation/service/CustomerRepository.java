package com.rhc.automation.service;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rhc.automation.model.Customer;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

}
