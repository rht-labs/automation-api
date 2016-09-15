package com.rhc.automation.service;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.rhc.automation.model.RoleMapping;

public interface UserRoleRepository extends PagingAndSortingRepository<RoleMapping, Long>{

}
