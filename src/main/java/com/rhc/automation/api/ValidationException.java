package com.rhc.automation.api;

public class ValidationException extends ApiException {

    private static final long serialVersionUID = 1L;

    public ValidationException(int code, String msg) {
        super(code, msg);
    }

}
