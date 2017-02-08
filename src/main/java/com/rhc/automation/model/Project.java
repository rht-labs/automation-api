package com.rhc.automation.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;




/**
 * Project
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-12T13:59:49.822-08:00")

public class Project   {
  private Long id = null;

  private String displayName = null;

  private String name = null;

  /**
   * Gets or Sets environmentType
   */
  public enum EnvironmentTypeEnum {
    BUILD("build"),

    PROMOTION("promotion");

    private String value;

    EnvironmentTypeEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private EnvironmentTypeEnum environmentType = null;

  private List<Application> apps = new ArrayList<Application>();

  private List<GroupRoleMapping> groupToRole = new ArrayList<GroupRoleMapping>();

  private List<RoleMapping> userToRole = new ArrayList<RoleMapping>();

  private List<PersistentVolumeClaim> persistentVolumeClaims = new ArrayList<PersistentVolumeClaim>();

  public Project id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
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
   * @return name
  **/
  @ApiModelProperty(required = true, value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Project environmentType(EnvironmentTypeEnum environmentType) {
    this.environmentType = environmentType;
    return this;
  }

   /**
   * Get environmentType
   * @return environmentType
  **/
  @ApiModelProperty(value = "")
  public EnvironmentTypeEnum getEnvironmentType() {
    return environmentType;
  }

  public void setEnvironmentType(EnvironmentTypeEnum environmentType) {
    this.environmentType = environmentType;
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
   * @return apps
  **/
  @ApiModelProperty(value = "")
  public List<Application> getApps() {
    return apps;
  }

  public void setApps(List<Application> apps) {
    this.apps = apps;
  }

  public Project groupToRole(List<GroupRoleMapping> groupToRole) {
    this.groupToRole = groupToRole;
    return this;
  }

  public Project addGroupToRoleItem(GroupRoleMapping groupToRoleItem) {
    this.groupToRole.add(groupToRoleItem);
    return this;
  }

   /**
   * Get groupToRole
   * @return groupToRole
  **/
  @ApiModelProperty(value = "")
  public List<GroupRoleMapping> getGroupToRole() {
    return groupToRole;
  }

  public void setGroupToRole(List<GroupRoleMapping> groupToRole) {
    this.groupToRole = groupToRole;
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
   * @return userToRole
  **/
  @ApiModelProperty(value = "")
  public List<RoleMapping> getUserToRole() {
    return userToRole;
  }

  public void setUserToRole(List<RoleMapping> userToRole) {
    this.userToRole = userToRole;
  }

  public Project persistentVolumeClaims(List<PersistentVolumeClaim> persistentVolumeClaims) {
    this.persistentVolumeClaims = persistentVolumeClaims;
    return this;
  }

  public Project addPersistentVolumeClaimsItem(PersistentVolumeClaim persistentVolumeClaimsItem) {
    this.persistentVolumeClaims.add(persistentVolumeClaimsItem);
    return this;
  }

   /**
   * Get persistentVolumeClaims
   * @return persistentVolumeClaims
  **/
  @ApiModelProperty(value = "")
  public List<PersistentVolumeClaim> getPersistentVolumeClaims() {
    return persistentVolumeClaims;
  }

  public void setPersistentVolumeClaims(List<PersistentVolumeClaim> persistentVolumeClaims) {
    this.persistentVolumeClaims = persistentVolumeClaims;
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
    return Objects.equals(this.id, project.id) &&
        Objects.equals(this.displayName, project.displayName) &&
        Objects.equals(this.name, project.name) &&
        Objects.equals(this.environmentType, project.environmentType) &&
        Objects.equals(this.apps, project.apps) &&
        Objects.equals(this.groupToRole, project.groupToRole) &&
        Objects.equals(this.userToRole, project.userToRole) &&
        Objects.equals(this.persistentVolumeClaims, project.persistentVolumeClaims);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, displayName, name, environmentType, apps, groupToRole, userToRole, persistentVolumeClaims);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Project {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    environmentType: ").append(toIndentedString(environmentType)).append("\n");
    sb.append("    apps: ").append(toIndentedString(apps)).append("\n");
    sb.append("    groupToRole: ").append(toIndentedString(groupToRole)).append("\n");
    sb.append("    userToRole: ").append(toIndentedString(userToRole)).append("\n");
    sb.append("    persistentVolumeClaims: ").append(toIndentedString(persistentVolumeClaims)).append("\n");
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

