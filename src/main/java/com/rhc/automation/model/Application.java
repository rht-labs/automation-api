package com.rhc.automation.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * Application
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-19T17:04:30.676-07:00")

public class Application implements AutomationModel {
    private Long id = null;

    private String baseImage = null;

    private String baseImageTag = null;

    private List<String> buildApplicationCommands = new ArrayList<String>();

    private String buildTool = null;

    private List<String> buildImageCommands = new ArrayList<String>();

    private List<String> deployImageCommands = new ArrayList<String>();

    private String contextDir = null;

    private String scmUrl = null;

    private String scmType = null;

    private String scmRef = null;

    private String name = null;

    private Map<String, String> labels = new HashMap<String, String>();

    private Map<String, String> environmentVariables = new HashMap<String, String>();

    public Application id(Long id) {
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

    public Application baseImage(String baseImage) {
        this.baseImage = baseImage;
        return this;
    }

    /**
     * Get baseImage
     * 
     * @return baseImage
     **/
    @ApiModelProperty(value = "")
    public String getBaseImage() {
        return baseImage;
    }

    public void setBaseImage(String baseImage) {
        this.baseImage = baseImage;
    }

    public Application baseImageTag(String baseImageTag) {
        this.baseImageTag = baseImageTag;
        return this;
    }

    /**
     * Get baseImageTag
     * 
     * @return baseImageTag
     **/
    @ApiModelProperty(value = "")
    public String getBaseImageTag() {
        return baseImageTag;
    }

    public void setBaseImageTag(String baseImageTag) {
        this.baseImageTag = baseImageTag;
    }

    public Application buildApplicationCommands(List<String> buildApplicationCommands) {
        this.buildApplicationCommands = buildApplicationCommands;
        return this;
    }

    public Application addBuildApplicationCommandsItem(String buildApplicationCommandsItem) {
        this.buildApplicationCommands.add(buildApplicationCommandsItem);
        return this;
    }

    /**
     * Get buildApplicationCommands
     * 
     * @return buildApplicationCommands
     **/
    @ApiModelProperty(value = "")
    public List<String> getBuildApplicationCommands() {
        return buildApplicationCommands;
    }

    public void setBuildApplicationCommands(List<String> buildApplicationCommands) {
        this.buildApplicationCommands = buildApplicationCommands;
    }

    public Application buildTool(String buildTool) {
        this.buildTool = buildTool;
        return this;
    }

    /**
     * Get buildTool
     * 
     * @return buildTool
     **/
    @ApiModelProperty(value = "")
    public String getBuildTool() {
        return buildTool;
    }

    public void setBuildTool(String buildTool) {
        this.buildTool = buildTool;
    }

    public Application buildImageCommands(List<String> buildImageCommands) {
        this.buildImageCommands = buildImageCommands;
        return this;
    }

    public Application addBuildImageCommandsItem(String buildImageCommandsItem) {
        this.buildImageCommands.add(buildImageCommandsItem);
        return this;
    }

    /**
     * Get buildImageCommands
     * 
     * @return buildImageCommands
     **/
    @ApiModelProperty(value = "")
    public List<String> getBuildImageCommands() {
        return buildImageCommands;
    }

    public void setBuildImageCommands(List<String> buildImageCommands) {
        this.buildImageCommands = buildImageCommands;
    }

    public Application deployImageCommands(List<String> deployImageCommands) {
        this.deployImageCommands = deployImageCommands;
        return this;
    }

    public Application addDeployImageCommandsItem(String deployImageCommandsItem) {
        this.deployImageCommands.add(deployImageCommandsItem);
        return this;
    }

    /**
     * Get deployImageCommands
     * 
     * @return deployImageCommands
     **/
    @ApiModelProperty(value = "")
    public List<String> getDeployImageCommands() {
        return deployImageCommands;
    }

    public void setDeployImageCommands(List<String> deployImageCommands) {
        this.deployImageCommands = deployImageCommands;
    }

    public Application contextDir(String contextDir) {
        this.contextDir = contextDir;
        return this;
    }

    /**
     * Get contextDir
     * 
     * @return contextDir
     **/
    @ApiModelProperty(value = "")
    public String getContextDir() {
        return contextDir;
    }

    public void setContextDir(String contextDir) {
        this.contextDir = contextDir;
    }

    public Application scmUrl(String scmUrl) {
        this.scmUrl = scmUrl;
        return this;
    }

    /**
     * Get scmUrl
     * 
     * @return scmUrl
     **/
    @ApiModelProperty(value = "")
    public String getScmUrl() {
        return scmUrl;
    }

    public void setScmUrl(String scmUrl) {
        this.scmUrl = scmUrl;
    }

    public Application scmType(String scmType) {
        this.scmType = scmType;
        return this;
    }

    /**
     * Get scmType
     * 
     * @return scmType
     **/
    @ApiModelProperty(value = "")
    public String getScmType() {
        return scmType;
    }

    public void setScmType(String scmType) {
        this.scmType = scmType;
    }

    public Application scmRef(String scmRef) {
        this.scmRef = scmRef;
        return this;
    }

    /**
     * Get scmRef
     * 
     * @return scmRef
     **/
    @ApiModelProperty(value = "")
    public String getScmRef() {
        return scmRef;
    }

    public void setScmRef(String scmRef) {
        this.scmRef = scmRef;
    }

    public Application name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     * 
     * @return name
     **/
    @ApiModelProperty(value = "")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Application labels(Map<String, String> labels) {
        this.labels = labels;
        return this;
    }

    public Application putLabelsItem(String key, String labelsItem) {
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

    public Application environmentVariables(Map<String, String> environmentVariables) {
        this.environmentVariables = environmentVariables;
        return this;
    }

    public Application putEnvironmentVariablesItem(String key, String environmentVariablesItem) {
        this.environmentVariables.put(key, environmentVariablesItem);
        return this;
    }

    /**
     * Get environmentVariables
     * 
     * @return environmentVariables
     **/
    @ApiModelProperty(value = "")
    public Map<String, String> getEnvironmentVariables() {
        return environmentVariables;
    }

    public void setEnvironmentVariables(Map<String, String> environmentVariables) {
        this.environmentVariables = environmentVariables;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Application application = (Application) o;
        return Objects.equals(this.id, application.id) && Objects.equals(this.baseImage, application.baseImage)
                && Objects.equals(this.baseImageTag, application.baseImageTag)
                && Objects.equals(this.buildApplicationCommands, application.buildApplicationCommands)
                && Objects.equals(this.buildTool, application.buildTool)
                && Objects.equals(this.buildImageCommands, application.buildImageCommands)
                && Objects.equals(this.deployImageCommands, application.deployImageCommands)
                && Objects.equals(this.contextDir, application.contextDir)
                && Objects.equals(this.scmUrl, application.scmUrl) && Objects.equals(this.scmType, application.scmType)
                && Objects.equals(this.scmRef, application.scmRef) && Objects.equals(this.name, application.name)
                && Objects.equals(this.labels, application.labels)
                && Objects.equals(this.environmentVariables, application.environmentVariables);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, baseImage, baseImageTag, buildApplicationCommands, buildTool, buildImageCommands,
                deployImageCommands, contextDir, scmUrl, scmType, scmRef, name, labels, environmentVariables);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Application {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    baseImage: ").append(toIndentedString(baseImage)).append("\n");
        sb.append("    baseImageTag: ").append(toIndentedString(baseImageTag)).append("\n");
        sb.append("    buildApplicationCommands: ").append(toIndentedString(buildApplicationCommands)).append("\n");
        sb.append("    buildTool: ").append(toIndentedString(buildTool)).append("\n");
        sb.append("    buildImageCommands: ").append(toIndentedString(buildImageCommands)).append("\n");
        sb.append("    deployImageCommands: ").append(toIndentedString(deployImageCommands)).append("\n");
        sb.append("    contextDir: ").append(toIndentedString(contextDir)).append("\n");
        sb.append("    scmUrl: ").append(toIndentedString(scmUrl)).append("\n");
        sb.append("    scmType: ").append(toIndentedString(scmType)).append("\n");
        sb.append("    scmRef: ").append(toIndentedString(scmRef)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
        sb.append("    environmentVariables: ").append(toIndentedString(environmentVariables)).append("\n");
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
