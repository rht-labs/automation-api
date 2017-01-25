package com.rhc.automation.exception;

public class EngagementNotFoundException extends Exception {
    private Long engagementId;

    public EngagementNotFoundException( Long engagementId ) {
        super( String.format( "could not find Engagement with ID %d", engagementId ) );
        this.engagementId = engagementId;
    }

    public Long getEngagementId() {
        return engagementId;
    }

    public void setEngagementId( Long engagementId ) {
        this.engagementId = engagementId;
    }
}
