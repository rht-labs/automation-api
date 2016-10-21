package com.rhc.automation.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.rhc.automation.model.User;

public interface UserRespository extends PagingAndSortingRepository<User, Long>, QueryByExampleExecutor<User> {

}
