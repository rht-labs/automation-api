package com.rhc.automation.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * Project
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-19T17:04:30.676-07:00")

public class Project implements AutomationModel {
    private Long id = null;

    private String displayName = null;

    private String name = null;

    private Boolean buildEnvironment = null;

    private Boolean promotionEnvironment = null;

    private List<Application> apps = new ArrayList<Application>();

    private List<RoleMapping> userToRole = new ArrayList<RoleMapping>();

    public Project id(Long id) {
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

    public Project displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get displayName
     * 
     * @return displayName
     **/
    @ApiModelProperty(value = "")
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Project name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     * 
     * @return name
     **/
    @ApiModelProperty(required = true, value = "")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project buildEnvironment(Boolean buildEnvironment) {
        this.buildEnvironment = buildEnvironment;
        return this;
    }

    /**
     * Get buildEnvironment
     * 
     * @return buildEnvironment
     **/
    @ApiModelProperty(value = "")
    public Boolean getBuildEnvironment() {
        return buildEnvironment;
    }

    public void setBuildEnvironment(Boolean buildEnvironment) {
        this.buildEnvironment = buildEnvironment;
    }

    public Project promotionEnvironment(Boolean promotionEnvironment) {
        this.promotionEnvironment = promotionEnvironment;
        return this;
    }

    /**
     * Get promotionEnvironment
     * 
     * @return promotionEnvironment
     **/
    @ApiModelProperty(value = "")
    public Boolean getPromotionEnvironment() {
        return promotionEnvironment;
    }

    public void setPromotionEnvironment(Boolean promotionEnvironment) {
        this.promotionEnvironment = promotionEnvironment;
    }

    public Project apps(List<Application> apps) {
        this.apps = apps;
        return this;
    }

    public Project addAppsItem(Application appsItem) {
        this.apps.add(appsItem);
        return this;
    }

    /**
     * Get apps
     * 
     * @return apps
     **/
    @ApiModelProperty(value = "")
    public List<Application> getApps() {
        return apps;
    }

    public void setApps(List<Application> apps) {
        this.apps = apps;
    }

    public Project userToRole(List<RoleMapping> userToRole) {
        this.userToRole = userToRole;
        return this;
    }

    public Project addUserToRoleItem(RoleMapping userToRoleItem) {
        this.userToRole.add(userToRoleItem);
        return this;
    }

    /**
     * Get userToRole
     * 
     * @return userToRole
     **/
    @ApiModelProperty(value = "")
    public List<RoleMapping> getUserToRole() {
        return userToRole;
    }

    public void setUserToRole(List<RoleMapping> userToRole) {
        this.userToRole = userToRole;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Project project = (Project) o;
        return Objects.equals(this.id, project.id) && Objects.equals(this.displayName, project.displayName)
                && Objects.equals(this.name, project.name)
                && Objects.equals(this.buildEnvironment, project.buildEnvironment)
                && Objects.equals(this.promotionEnvironment, project.promotionEnvironment)
                && Objects.equals(this.apps, project.apps) && Objects.equals(this.userToRole, project.userToRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, displayName, name, buildEnvironment, promotionEnvironment, apps, userToRole);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Project {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    buildEnvironment: ").append(toIndentedString(buildEnvironment)).append("\n");
        sb.append("    promotionEnvironment: ").append(toIndentedString(promotionEnvironment)).append("\n");
        sb.append("    apps: ").append(toIndentedString(apps)).append("\n");
        sb.append("    userToRole: ").append(toIndentedString(userToRole)).append("\n");
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
    