package com.rhc.automation.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;




/**
 * PVCAssociation
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-12T13:59:49.822-08:00")

public class PVCAssociation   {
  private Long id = null;

  private String name = null;

  private String mountPath = null;

  private ClaimType claimType = null;

  public PVCAssociation id(Long id) {
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

  public PVCAssociation name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PVCAssociation mountPath(String mountPath) {
    this.mountPath = mountPath;
    return this;
  }

   /**
   * Get mountPath
   * @return mountPath
  **/
  @ApiModelProperty(value = "")
  public String getMountPath() {
    return mountPath;
  }

  public void setMountPath(String mountPath) {
    this.mountPath = mountPath;
  }

  public PVCAssociation claimType(ClaimType claimType) {
    this.claimType = claimType;
    return this;
  }

   /**
   * Get claimType
   * @return claimType
  **/
  @ApiModelProperty(value = "")
  public ClaimType getClaimType() {
    return claimType;
  }

  public void setClaimType(ClaimType claimType) {
    this.claimType = claimType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PVCAssociation pVCAssociation = (PVCAssociation) o;
    return Objects.equals(this.id, pVCAssociation.id) &&
        Objects.equals(this.name, pVCAssociation.name) &&
        Objects.equals(this.mountPath, pVCAssociation.mountPath) &&
        Objects.equals(this.claimType, pVCAssociation.claimType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, mountPath, claimType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PVCAssociation {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    mountPath: ").append(toIndentedString(mountPath)).append("\n");
    sb.append("    claimType: ").append(toIndentedString(claimType)).append("\n");
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

