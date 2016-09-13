package com.rhc.automation.service;

import org.springframework.data.repository.CrudRepository;

import com.rhc.automation.model.RoleMapping;

public interface UserRoleRepository extends CrudRepository<RoleMapping, Long>{

}
