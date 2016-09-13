package com.rhc.automation.model;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * ErrorModel
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-08T13:44:26.455-07:00")

public class ErrorModel {
    private String message = null;

    private Integer code = null;

    public ErrorModel message(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get message
     * 
     * @return message
     **/
    @ApiModelProperty(required = true, value = "")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorModel code(Integer code) {
        this.code = code;
        return this;
    }

    /**
     * Get code minimum: 100.0 maximum: 600.0
     * 
     * @return code
     **/
    @ApiModelProperty(required = true, value = "")
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ErrorModel errorModel = (ErrorModel) o;
        return Objects.equals(this.message, errorModel.message) && Objects.equals(this.code, errorModel.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, code);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ErrorModel {\n");

        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
