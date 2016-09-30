package com.rhc.automation.service;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rhc.automation.model.Role;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {

    
}
