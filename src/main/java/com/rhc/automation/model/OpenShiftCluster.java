package com.rhc.automation.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * OpenShiftCluster
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-19T17:04:30.676-07:00")

public class OpenShiftCluster implements AutomationModel {
    private Long id = null;

    private Map<String, String> labels = new HashMap<String, String>();

    private OpenShiftResources openShiftResources = null;

    private String openShiftHostEnv = null;

    private String userId = null;

    private String imageRegistry = null;

    public OpenShiftCluster id(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     * 
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
     * 
     * @return labels
     **/
    @ApiModelProperty(value = "")
    public Map<String, String> getLabels() {
        return labels;
    }

    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    public OpenShiftCluster openShiftResources(OpenShiftResources openShiftResources) {
        this.openShiftResources = openShiftResources;
        return this;
    }

    /**
     * Get openShiftResources
     * 
     * @return openShiftResources
     **/
    @ApiModelProperty(value = "")
    public OpenShiftResources getOpenShiftResources() {
        return openShiftResources;
    }

    public void setOpenShiftResources(OpenShiftResources openShiftResources) {
        this.openShiftResources = openShiftResources;
    }

    public OpenShiftCluster openShiftHostEnv(String openShiftHostEnv) {
        this.openShiftHostEnv = openShiftHostEnv;
        return this;
    }

    /**
     * Get openShiftHostEnv
     * 
     * @return openShiftHostEnv
     **/
    @ApiModelProperty(value = "")
    public String getOpenShiftHostEnv() {
        return openShiftHostEnv;
    }

    public void setOpenShiftHostEnv(String openShiftHostEnv) {
        this.openShiftHostEnv = openShiftHostEnv;
    }

    public OpenShiftCluster userId(String userId) {
        this.userId = userId;
        return this;
    }

    /**
     * Get userId
     * 
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
     * 
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
        return Objects.equals(this.id, openShiftCluster.id) && Objects.equals(this.labels, openShiftCluster.labels)
                && Objects.equals(this.openShiftResources, openShiftCluster.openShiftResources)
                && Objects.equals(this.openShiftHostEnv, openShiftCluster.openShiftHostEnv)
                && Objects.equals(this.userId, openShiftCluster.userId)
                && Objects.equals(this.imageRegistry, openShiftCluster.imageRegistry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, labels, openShiftResources, openShiftHostEnv, userId, imageRegistry);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OpenShiftCluster {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
        sb.append("    openShiftResources: ").append(toIndentedString(openShiftResources)).append("\n");
        sb.append("    openShiftHostEnv: ").append(toIndentedString(openShiftHostEnv)).append("\n");
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
