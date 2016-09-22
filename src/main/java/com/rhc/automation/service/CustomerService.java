package com.rhc.automation.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rhc.automation.model.Engagement;
import com.rhc.automation.model.Customer;

public interface CustomerService {

    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(Long customerId);
    Customer getCustomer(Long customerId);
    Page<Customer> getCustomers(Pageable pager);
    
    void addEngagement(Engagement engagement);
    void updateEngagement(Engagement engagement);
    void deleteEngagement(Long engagementId);
    Engagement getEngagement(Long engagementId);
    Page<Engagement> getEngagements(Pageable pager);

}
