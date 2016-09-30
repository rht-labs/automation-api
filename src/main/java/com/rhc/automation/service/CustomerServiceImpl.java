package com.rhc.automation.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.rhc.automation.api.NotFoundException;
import com.rhc.automation.model.Customer;
import com.rhc.automation.model.Engagement;
import com.rhc.automation.model.OpenShiftCluster;
import com.rhc.automation.model.User;

@Component("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private EngagementRepository engagementRepository;
    private CustomerRepository customerRepository;
    private OpenShiftService openshiftService;
    private UserService userService;
    
    public CustomerServiceImpl(ApplicationRepository applicationRepository, EngagementRepository engagementRepository,
            CustomerRepository customerRepository, OpenShiftService openshiftService, UserService userService) {
        this.engagementRepository = engagementRepository;
        this.customerRepository = customerRepository;
        this.openshiftService = openshiftService;
        this.userService = userService;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
        
    }

    @Override
    public void updateCustomer(Customer customer) {
        Customer current = customerRepository.findOne(customer.getId());
        
        if(current == null) {
            throw new NotFoundException(404, String.format("Customer with id %d, not found", customer.getId()));
        }
        
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.delete(customerId);
        
    }

    @Override
    public Customer getCustomer(Long customerId) {
        return customerRepository.findOne(customerId);
    }

    @Override
    public Page<Customer> getCustomers(Pageable pager) {
        return customerRepository.findAll(pager);
    }

    @Override
    public void addEngagement(Engagement engagement) {
        for(OpenShiftCluster cluster : engagement.getOpenShiftClusters()) {
            if(cluster.getId() == null || cluster.getId() == 0) {
                cluster.setId(null);
                openshiftService.addOpenShiftCluster(cluster);
            }
            
        }
        
        for(User user : engagement.getTeam()) {
            if(user.getId() == null || user.getId() == 0) {
                user.setId(null);
                userService.addUser(user);
            }
        }
        
        engagementRepository.save(engagement);
        
    }

    @Override
    public void updateEngagement(Engagement engagement) {
        Engagement current = engagementRepository.findOne(engagement.getId());
        
        if(current == null) {
            throw new NotFoundException(404, String.format("Engagement with id %d, not found", engagement.getId()));
        }
        
        engagementRepository.save(engagement);
        
    }

    @Override
    public void deleteEngagement(Long engagementId) {
        engagementRepository.delete(engagementId);
        
    }

    @Override
    public Engagement getEngagement(Long engagementId) {
        return engagementRepository.findOne(engagementId);
    }

    @Override
    public Page<Engagement> getEngagements(Pageable pager) {
        return engagementRepository.findAll(pager);
    }

}
