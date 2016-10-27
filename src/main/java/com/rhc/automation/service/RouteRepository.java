package com.rhc.automation.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.rhc.automation.model.Route;

public interface RouteRepository extends PagingAndSortingRepository<Route, Long>, QueryByExampleExecutor<Route> {

}
