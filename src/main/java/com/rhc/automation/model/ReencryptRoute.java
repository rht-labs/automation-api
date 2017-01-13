package com.rhc.automation.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.rhc.automation.model.Route;
import com.rhc.automation.model.Service;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * ReencryptRoute
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-12T13:59:49.822-08:00")

public class ReencryptRoute extends Route  {
  private String caCert = null;

  private String cert = null;

  private String destCaCert = null;

  private String insecurePolicy = null;

  private String key = null;

  private String path = null;

  public ReencryptRoute caCert(String caCert) {
    this.caCert = caCert;
    return this;
  }

   /**
   * Get caCert
   * @return caCert
  **/
  @ApiModelProperty(value = "")
  public String getCaCert() {
    return caCert;
  }

  public void setCaCert(String caCert) {
    this.caCert = caCert;
  }

  public ReencryptRoute cert(String cert) {
    this.cert = cert;
    return this;
  }

   /**
   * Get cert
   * @return cert
  **/
  @ApiModelProperty(value = "")
  public String getCert() {
    return cert;
  }

  public void setCert(String cert) {
    this.cert = cert;
  }

  public ReencryptRoute destCaCert(String destCaCert) {
    this.destCaCert = destCaCert;
    return this;
  }

   /**
   * Get destCaCert
   * @return destCaCert
  **/
  @ApiModelProperty(value = "")
  public String getDestCaCert() {
    return destCaCert;
  }

  public void setDestCaCert(String destCaCert) {
    this.destCaCert = destCaCert;
  }

  public ReencryptRoute insecurePolicy(String insecurePolicy) {
    this.insecurePolicy = insecurePolicy;
    return this;
  }

   /**
   * Get insecurePolicy
   * @return insecurePolicy
  **/
  @ApiModelProperty(value = "")
  public String getInsecurePolicy() {
    return insecurePolicy;
  }

  public void setInsecurePolicy(String insecurePolicy) {
    this.insecurePolicy = insecurePolicy;
  }

  public ReencryptRoute key(String key) {
    this.key = key;
    return this;
  }

   /**
   * Get key
   * @return key
  **/
  @ApiModelProperty(value = "")
  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public ReencryptRoute path(String path) {
    this.path = path;
    return this;
  }

   /**
   * Get path
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
    ReencryptRoute reencryptRoute = (ReencryptRoute) o;
    return Objects.equals(this.caCert, reencryptRoute.caCert) &&
        Objects.equals(this.cert, reencryptRoute.cert) &&
        Objects.equals(this.destCaCert, reencryptRoute.destCaCert) &&
        Objects.equals(this.insecurePolicy, reencryptRoute.insecurePolicy) &&
        Objects.equals(this.key, reencryptRoute.key) &&
        Objects.equals(this.path, reencryptRoute.path) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(caCert, cert, destCaCert, insecurePolicy, key, path, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReencryptRoute {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    caCert: ").append(toIndentedString(caCert)).append("\n");
    sb.append("    cert: ").append(toIndentedString(cert)).append("\n");
    sb.append("    destCaCert: ").append(toIndentedString(destCaCert)).append("\n");
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

