package com.rhc.automation.repo;

import com.rhc.automation.exception.EngagementNotFoundException;
import com.rhc.automation.exception.InvalidEngagementException;
import com.rhc.automation.model.Engagement;

import java.util.List;

public interface EngagementRepository {

    void save( Engagement engagement ) throws InvalidEngagementException;

    boolean save( Engagement engagement, Long id ) throws InvalidEngagementException;

    void delete( Long id ) throws EngagementNotFoundException;

    void deleteAll();

    Long count();

    List<Engagement> getAll();

    List<Engagement> findByNameContainingIgnoreCase( String nameSearchTerm );

    List<Engagement> findByNameContainingIgnoreCase( String nameSearchTerm, Integer size, Long offset );

    Engagement findById( Long id ) throws EngagementNotFoundException;
}
