package com.rhc.automation.service;

import org.springframework.data.repository.CrudRepository;

import com.rhc.automation.model.OpenshiftCluster;

public interface OpenshiftClusterRepository extends CrudRepository<OpenshiftCluster, Long>{

}
