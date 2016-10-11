package com.rhc.automation.model;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * EdgeRoute
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-06T10:52:08.748-07:00")

public class EdgeRoute extends Route {
    private String caCert = null;

    private String cert = null;

    private String insecurePolicy = null;

    private String key = null;

    private String path = null;

    public EdgeRoute caCert(String caCert) {
        this.caCert = caCert;
        return this;
    }

    /**
     * Get caCert
     * 
     * @return caCert
     **/
    @ApiModelProperty(value = "")
    public String getCaCert() {
        return caCert;
    }

    public void setCaCert(String caCert) {
        this.caCert = caCert;
    }

    public EdgeRoute cert(String cert) {
        this.cert = cert;
        return this;
    }

    /**
     * Get cert
     * 
     * @return cert
     **/
    @ApiModelProperty(value = "")
    public String getCert() {
        return cert;
    }

    public void setCert(String cert) {
        this.cert = cert;
    }

    public EdgeRoute insecurePolicy(String insecurePolicy) {
        this.insecurePolicy = insecurePolicy;
        return this;
    }

    /**
     * Get insecurePolicy
     * 
     * @return insecurePolicy
     **/
    @ApiModelProperty(value = "")
    public String getInsecurePolicy() {
        return insecurePolicy;
    }

    public void setInsecurePolicy(String insecurePolicy) {
        this.insecurePolicy = insecurePolicy;
    }

    public EdgeRoute key(String key) {
        this.key = key;
        return this;
    }

    /**
     * Get key
     * 
     * @return key
     **/
    @ApiModelProperty(value = "")
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public EdgeRoute path(String path) {
        this.path = path;
        return this;
    }

    /**
     * Get path
     * 
     * @return path
     **/
    @ApiModelProperty(value = "")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EdgeRoute edgeRoute = (EdgeRoute) o;
        return Objects.equals(this.caCert, edgeRoute.caCert) && Objects.equals(this.cert, edgeRoute.cert)
                && Objects.equals(this.insecurePolicy, edgeRoute.insecurePolicy)
                && Objects.equals(this.key, edgeRoute.key) && Objects.equals(this.path, edgeRoute.path)
                && super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caCert, cert, insecurePolicy, key, path, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EdgeRoute {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    caCert: ").append(toIndentedString(caCert)).append("\n");
        sb.append("    cert: ").append(toIndentedString(cert)).append("\n");
        sb.append("    insecurePolicy: ").append(toIndentedString(insecurePolicy)).append("\n");
        sb.append("    key: ").append(toIndentedString(key)).append("\n");
        sb.append("    path: ").append(toIndentedString(path)).append("\n");
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
