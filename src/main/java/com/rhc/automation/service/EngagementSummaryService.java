package com.rhc.automation.service;

import com.rhc.automation.model.EngagementSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EngagementSummaryService {
    @Autowired
    private EngagementService engagementService;

    public EngagementSummaryService(){
    }

    public  EngagementSummaryService( EngagementService engagementService){
        this.engagementService = engagementService;
    }

    public List<EngagementSummary> engagementSummariesList( String nameSearchTerm, Integer size, Long offset ) {
        return engagementService.engagementList( nameSearchTerm, size, offset ).stream().map( e -> new EngagementSummary( e ) ).collect( Collectors.toList() );
        //return  new ArrayList<>(  );
    }

    public List<EngagementSummary> engagementSummariesList( String nameSearchTerm ) {
        return engagementSummariesList( nameSearchTerm, null, null );
    }

    public List<EngagementSummary> engagementSummariesList() {
        return engagementSummariesList( null, null, null );
    }
}
