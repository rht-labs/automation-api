package com.rhc.automation.exception;

import java.util.List;

public class InvalidEngagementException extends Exception {

    private final List<String> invalidFields;

    public InvalidEngagementException( List<String> invalidFields ) {
        super( String.format( "The following field are invalid: %s", invalidFields.toString() ) );
        this.invalidFields = invalidFields;
    }

    public List<String> getInvalidFields() {
        return invalidFields;
    }
}
