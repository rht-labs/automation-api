package com.rhc.automation.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.rhc.automation.model.Port;

public interface PortRepository extends PagingAndSortingRepository<Port, Long>, QueryByExampleExecutor<Port> {

}
