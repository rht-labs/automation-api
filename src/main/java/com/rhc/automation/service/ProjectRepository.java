package com.rhc.automation.service;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rhc.automation.model.Project;

public interface ProjectRepository extends PagingAndSortingRepository<Project, Long>{

}
