package com.rhc.automation.repo;

import com.rhc.automation.model.EngagementSummary;

import java.util.List;

public interface EngagementSummaryRepository {


    List<EngagementSummary> findByNameContainingIgnoreCase( String nameSearchTerm, Integer size, Long offset );

    List<EngagementSummary> findByNameContainingIgnoreCase( String nameSearchTerm );

    List<EngagementSummary> getAll();
}
