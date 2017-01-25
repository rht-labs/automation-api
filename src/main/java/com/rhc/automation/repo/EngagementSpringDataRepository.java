package com.rhc.automation.repo;

import com.rhc.automation.model.Engagement;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface EngagementSpringDataRepository extends PagingAndSortingRepository<Engagement, Long> {

    List<Engagement> findByNameContainingIgnoreCase(String name);
}
