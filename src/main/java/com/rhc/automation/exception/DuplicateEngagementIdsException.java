package com.rhc.automation.exception;

import com.rhc.automation.model.Engagement;

import java.util.List;

public class DuplicateEngagementIdsException extends Exception{

    private final List<Engagement> duplicationEngagements;
    private final Long id;

    public DuplicateEngagementIdsException( List<Engagement> duplicationEngagements, Long id ) {
        super( String.format( "%d engagements found for ID %d", duplicationEngagements.size(), id ) );
        this.duplicationEngagements = duplicationEngagements;
        this.id = id;
    }

    public List<Engagement> getDuplicationEngagements() {
        return duplicationEngagements;
    }

    public Long getId() {
        return id;
    }
}
