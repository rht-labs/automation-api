package com.rhc.automation.service;

import org.springframework.data.repository.CrudRepository;

import com.rhc.automation.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
