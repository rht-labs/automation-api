package com.rhc.automation.model;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * Port
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-06T14:53:20.963-07:00")

public class Port {
    private Long id = null;

    private Integer port = null;

    private String protocol = null;

    private Integer targetPort = null;

    public Port id(Long id) {
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

    public Port port(Integer port) {
        this.port = port;
        return this;
    }

    /**
     * Get port
     * 
     * @return port
     **/
    @ApiModelProperty(required = true, value = "")
    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Port protocol(String protocol) {
        this.protocol = protocol;
        return this;
    }

    /**
     * Get protocol
     * 
     * @return protocol
     **/
    @ApiModelProperty(required = true, value = "")
    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Port targetPort(Integer targetPort) {
        this.targetPort = targetPort;
        return this;
    }

    /**
     * Get targetPort
     * 
     * @return targetPort
     **/
    @ApiModelProperty(required = true, value = "")
    public Integer getTargetPort() {
        return targetPort;
    }

    public void setTargetPort(Integer targetPort) {
        this.targetPort = targetPort;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Port port = (Port) o;
        return Objects.equals(this.id, port.id) && Objects.equals(this.port, port.port)
                && Objects.equals(this.protocol, port.protocol) && Objects.equals(this.targetPort, port.targetPort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, port, protocol, targetPort);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Port {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    port: ").append(toIndentedString(port)).append("\n");
        sb.append("    protocol: ").append(toIndentedString(protocol)).append("\n");
        sb.append("    targetPort: ").append(toIndentedString(targetPort)).append("\n");
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
