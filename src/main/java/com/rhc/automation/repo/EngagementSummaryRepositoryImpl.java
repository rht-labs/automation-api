package com.rhc.automation.repo;

import com.rhc.automation.model.EngagementSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EngagementSummaryRepositoryImpl implements EngagementSummaryRepository{

    @Autowired
    private EngagementRepository engagementRepository;

    public List<EngagementSummary> findByNameContainingIgnoreCase( String nameSearchTerm, Integer size, Long offset ) {
        throw new NotImplementedException();
    }

    public List<EngagementSummary> findByNameContainingIgnoreCase( String nameSearchTerm ) {
        if ( nameSearchTerm == null || nameSearchTerm.isEmpty() ){
            return engagementRepository.getAll().stream().map( e -> new EngagementSummary( e ) ).collect( Collectors.toList() );
        } else {
            return engagementRepository.findByNameContainingIgnoreCase( nameSearchTerm ).stream().map( e -> new EngagementSummary( e ) ).collect( Collectors.toList() );
        }

    }

    public List<EngagementSummary> getAll() {
        return findByNameContainingIgnoreCase( null);
    }

}
