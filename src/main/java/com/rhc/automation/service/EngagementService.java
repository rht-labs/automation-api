package com.rhc.automation.service;

import com.rhc.automation.exception.InvalidEngagementException;
import com.rhc.automation.model.Engagement;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EngagementService {

    private Long counter = 0l;
    private List<Engagement> engagementList = new ArrayList<>();

    public void addEngagement(Engagement engagement) throws InvalidEngagementException {
        if (engagement.getId() == null ){
            engagement.setId( ++counter );
        }
        if (engagement.determineIfValid()) {
            engagementList.add(engagement);
        } else {
            throw new InvalidEngagementException("foo");
        }
    }

    public Integer getNumberOfEngagements(){
        return engagementList.size();
    }

    public List<Engagement> getEngagementList(){
        return engagementList;
    }
}
