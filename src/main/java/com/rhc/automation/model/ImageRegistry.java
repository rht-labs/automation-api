package com.rhc.automation.model;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * ImageRegistry
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-08T13:44:26.455-07:00")

public class ImageRegistry {
    private Long id = null;

    private String host = null;

    public ImageRegistry id(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     * 
     * @return id
     **/
    @ApiModelProperty(value = "")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ImageRegistry host(String host) {
        this.host = host;
        return this;
    }

    /**
     * Get host
     * 
     * @return host
     **/
    @ApiModelProperty(required = true, value = "")
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ImageRegistry imageRegistry = (ImageRegistry) o;
        return Objects.equals(this.id, imageRegistry.id) && Objects.equals(this.host, imageRegistry.host);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, host);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ImageRegistry {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    host: ").append(toIndentedString(host)).append("\n");
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
