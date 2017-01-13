package com.rhc.automation.service;

import com.rhc.automation.exception.DuplicateEngagementIdsException;
import com.rhc.automation.exception.EngagementNotFoundException;
import com.rhc.automation.exception.InvalidEngagementException;
import com.rhc.automation.model.Engagement;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EngagementService {

    private Long counter = 0l;
    private List<Engagement> engagementList = new ArrayList<>();

    /****************************************************************************************
     * Commands
     ****************************************************************************************/

    public void addEngagement( Engagement engagement ) throws InvalidEngagementException {
        if ( engagement.getId() == null ) {
            engagement.setId( nextId() );
        }
        if ( engagement.determineIfValid() ) {
            engagementList.add( engagement );
        } else {
            throw new InvalidEngagementException( engagement.determineInvalidFields() );
        }
    }

    /**
     * @param engagement
     * @param id
     * @return if a new Engagement was created, as opposed to updated
     * @throws InvalidEngagementException
     */
    public boolean addEngagement( Engagement engagement, Long id ) throws InvalidEngagementException {
        boolean newEngagementCreated = false;
        try {
            // engagement updated
            deleteEngagementById( id );

        } catch ( EngagementNotFoundException engagementNotFoundException ) {
            newEngagementCreated = true;
        }
        engagement.setId( id );
        addEngagement( engagement );
        return newEngagementCreated;
    }

    public void deleteEngagementById( Long id ) throws EngagementNotFoundException {
        List<Engagement> newList = engagementList.stream().filter( e -> !e.getId().equals( id ) ).collect( Collectors.toList() );
        if ( newList.size() == engagementList.size() ) {
            throw new EngagementNotFoundException( id );
        } else {
            engagementList = newList;
        }
    }

    /****************************************************************************************
     * Queries
     ****************************************************************************************/

    public List<Engagement> engagementList() {
        return engagementList( null, null, null );
    }

    public List<Engagement> engagementList( String nameSearchTerm ) {
        return engagementList( nameSearchTerm, null, null );
    }

    public List<Engagement> engagementList( String nameSearchTerm, Integer size, Long offset ) {
        if ( isValidSearchTerm( nameSearchTerm ) ) {
            return engagementsWithSearchTermInTheirName( nameSearchTerm );
        }
        return engagementList;
    }

    private List<Engagement> engagementsWithSearchTermInTheirName( String nameSearchTerm ) {
        List<Engagement> searchResults = engagementList.stream().filter( e -> e.nameContainsSearchTerm( nameSearchTerm ) ).collect( Collectors.toList() );
        return searchResults;
    }

    public Engagement engagement( Long id ) throws EngagementNotFoundException, DuplicateEngagementIdsException {
        List<Engagement> searchResults = collectEngagementsWithId( id );
        if ( searchResults.size() == 0 ) {
            throw new EngagementNotFoundException( id );
        } else if ( searchResults.size() > 1 ) {
            throw new DuplicateEngagementIdsException( searchResults, id );
        } else {
            return searchResults.get( 0 );
        }
    }


    /****************************************************************************************
     * Helpers
     ****************************************************************************************/

    private boolean isValidSearchTerm( String nameSearchTerm ) {
        if ( nameSearchTerm == null ) return false;
        if ( nameSearchTerm.isEmpty() ) return false;
        return true;
    }

    private List<Engagement> collectEngagementsWithId( Long id ) {
        return engagementList.stream().filter( e -> e.getId().equals( id ) ).collect( Collectors.toList() );
    }

    private Long nextId() {
        while ( true ) {
            Long nextId = counter++;
            List<Engagement> searchResults = collectEngagementsWithId( nextId );
            if ( searchResults.size() == 0 ) {
                return nextId;
            }
        }
    }

}
