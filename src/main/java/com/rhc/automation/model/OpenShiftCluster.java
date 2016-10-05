package com.rhc.automation.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.rhc.automation.model.OpenShiftResources;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




/**
 * OpenShiftCluster
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-05T12:23:04.865-07:00")

public class OpenShiftCluster implements AutomationModel  {
  private Long id = null;

  private Map<String, String> labels = new HashMap<String, String>();

  private OpenShiftResources openshiftResources = null;

  private String openshiftHostEnv = null;

  private String userId = null;

  private String imageRegistry = null;

  public OpenShiftCluster id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public OpenShiftCluster labels(Map<String, String> labels) {
    this.labels = labels;
    return this;
  }

  public OpenShiftCluster putLabelsItem(String key, String labelsItem) {
    this.labels.put(key, labelsItem);
    return this;
  }

   /**
   * Get labels
   * @return labels
  **/
  @ApiModelProperty(value = "")
  public Map<String, String> getLabels() {
    return labels;
  }

  public void setLabels(Map<String, String> labels) {
    this.labels = labels;
  }

  public OpenShiftCluster openshiftResources(OpenShiftResources openshiftResources) {
    this.openshiftResources = openshiftResources;
    return this;
  }

   /**
   * Get openshiftResources
   * @return openshiftResources
  **/
  @ApiModelProperty(value = "")
  public OpenShiftResources getOpenshiftResources() {
    return openshiftResources;
  }

  public void setOpenshiftResources(OpenShiftResources openshiftResources) {
    this.openshiftResources = openshiftResources;
  }

  public OpenShiftCluster openshiftHostEnv(String openshiftHostEnv) {
    this.openshiftHostEnv = openshiftHostEnv;
    return this;
  }

   /**
   * Get openshiftHostEnv
   * @return openshiftHostEnv
  **/
  @ApiModelProperty(value = "")
  public String getOpenshiftHostEnv() {
    return openshiftHostEnv;
  }

  public void setOpenshiftHostEnv(String openshiftHostEnv) {
    this.openshiftHostEnv = openshiftHostEnv;
  }

  public OpenShiftCluster userId(String userId) {
    this.userId = userId;
    return this;
  }

   /**
   * Get userId
   * @return userId
  **/
  @ApiModelProperty(value = "")
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public OpenShiftCluster imageRegistry(String imageRegistry) {
    this.imageRegistry = imageRegistry;
    return this;
  }

   /**
   * Get imageRegistry
   * @return imageRegistry
  **/
  @ApiModelProperty(value = "")
  public String getImageRegistry() {
    return imageRegistry;
  }

  public void setImageRegistry(String imageRegistry) {
    this.imageRegistry = imageRegistry;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OpenShiftCluster openShiftCluster = (OpenShiftCluster) o;
    return Objects.equals(this.id, openShiftCluster.id) &&
        Objects.equals(this.labels, openShiftCluster.labels) &&
        Objects.equals(this.openshiftResources, openShiftCluster.openshiftResources) &&
        Objects.equals(this.openshiftHostEnv, openShiftCluster.openshiftHostEnv) &&
        Objects.equals(this.userId, openShiftCluster.userId) &&
        Objects.equals(this.imageRegistry, openShiftCluster.imageRegistry);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, labels, openshiftResources, openshiftHostEnv, userId, imageRegistry);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OpenShiftCluster {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
    sb.append("    openshiftResources: ").append(toIndentedString(openshiftResources)).append("\n");
    sb.append("    openshiftHostEnv: ").append(toIndentedString(openshiftHostEnv)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    imageRegistry: ").append(toIndentedString(imageRegistry)).append("\n");
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

