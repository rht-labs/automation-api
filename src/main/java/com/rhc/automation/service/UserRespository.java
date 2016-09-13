package com.rhc.automation.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.rhc.automation.model.User;

public interface UserRespository extends PagingAndSortingRepository<User, Long>{

}
