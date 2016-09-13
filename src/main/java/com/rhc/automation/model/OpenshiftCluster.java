package com.rhc.automation.model;

import java.util.Objects;
import com.rhc.automation.model.ImageRegistry;
import com.rhc.automation.model.OpenshiftResources;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.Map;

/**
 * OpenshiftCluster
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-12T14:56:41.032-07:00")

public class OpenshiftCluster   {
  private Long id = null;

  private Map<String, String> labels = new HashMap<String, String>();

  private OpenshiftResources openshiftResourcesToCreate = null;

  private String openshiftHostEnv = null;

  private ImageRegistry imageRegistry = null;

  public OpenshiftCluster id(Long id) {
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

  public OpenshiftCluster labels(Map<String, String> labels) {
    this.labels = labels;
    return this;
  }

  public OpenshiftCluster putLabelsItem(String key, String labelsItem) {
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

  public OpenshiftCluster openshiftResourcesToCreate(OpenshiftResources openshiftResourcesToCreate) {
    this.openshiftResourcesToCreate = openshiftResourcesToCreate;
    return this;
  }

   /**
   * Get openshiftResourcesToCreate
   * @return openshiftResourcesToCreate
  **/
  @ApiModelProperty(value = "")
  public OpenshiftResources getOpenshiftResourcesToCreate() {
    return openshiftResourcesToCreate;
  }

  public void setOpenshiftResourcesToCreate(OpenshiftResources openshiftResourcesToCreate) {
    this.openshiftResourcesToCreate = openshiftResourcesToCreate;
  }

  public OpenshiftCluster openshiftHostEnv(String openshiftHostEnv) {
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

  public OpenshiftCluster imageRegistry(ImageRegistry imageRegistry) {
    this.imageRegistry = imageRegistry;
    return this;
  }

   /**
   * Get imageRegistry
   * @return imageRegistry
  **/
  @ApiModelProperty(value = "")
  public ImageRegistry getImageRegistry() {
    return imageRegistry;
  }

  public void setImageRegistry(ImageRegistry imageRegistry) {
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
    OpenshiftCluster openshiftCluster = (OpenshiftCluster) o;
    return Objects.equals(this.id, openshiftCluster.id) &&
        Objects.equals(this.labels, openshiftCluster.labels) &&
        Objects.equals(this.openshiftResourcesToCreate, openshiftCluster.openshiftResourcesToCreate) &&
        Objects.equals(this.openshiftHostEnv, openshiftCluster.openshiftHostEnv) &&
        Objects.equals(this.imageRegistry, openshiftCluster.imageRegistry);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, labels, openshiftResourcesToCreate, openshiftHostEnv, imageRegistry);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OpenshiftCluster {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
    sb.append("    openshiftResourcesToCreate: ").append(toIndentedString(openshiftResourcesToCreate)).append("\n");
    sb.append("    openshiftHostEnv: ").append(toIndentedString(openshiftHostEnv)).append("\n");
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

