package com.rhc.automation.api;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-08T13:44:26.455-07:00")

public class ApiException extends RuntimeException{
	private int code;
	public ApiException (int code, String msg) {
		super(msg);
		this.code = code;
	}
}
