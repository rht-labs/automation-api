package com.rhc.automation.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




/**
 * PersistentVolume
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-12T13:59:49.822-08:00")

public class PersistentVolume   {
  private Long id = null;

  private String name = null;

  private Long capacity = null;

  /**
   * Gets or Sets accessModes
   */
  public enum AccessModesEnum {
    READWRITEONCE("ReadWriteOnce"),
    
    READONLYMANY("ReadOnlyMany"),
    
    READWRITEMANY("ReadWriteMany");

    private String value;

    AccessModesEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private List<AccessModesEnum> accessModes = new ArrayList<AccessModesEnum>();

  private String nfsPath = null;

  private String nfsServer = null;

  /**
   * Gets or Sets reclaimPolicy
   */
  public enum ReclaimPolicyEnum {
    RETAIN("Retain"),
    
    RECYCLE("Recycle");

    private String value;

    ReclaimPolicyEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private ReclaimPolicyEnum reclaimPolicy = null;

  private Map<String, String> labels = new HashMap<String, String>();

  public PersistentVolume id(Long id) {
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

  public PersistentVolume name(String name) {
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

  public PersistentVolume capacity(Long capacity) {
    this.capacity = capacity;
    return this;
  }

   /**
   * Get capacity
   * @return capacity
  **/
  @ApiModelProperty(value = "")
  public Long getCapacity() {
    return capacity;
  }

  public void setCapacity(Long capacity) {
    this.capacity = capacity;
  }

  public PersistentVolume accessModes(List<AccessModesEnum> accessModes) {
    this.accessModes = accessModes;
    return this;
  }

  public PersistentVolume addAccessModesItem(AccessModesEnum accessModesItem) {
    this.accessModes.add(accessModesItem);
    return this;
  }

   /**
   * Get accessModes
   * @return accessModes
  **/
  @ApiModelProperty(value = "")
  public List<AccessModesEnum> getAccessModes() {
    return accessModes;
  }

  public void setAccessModes(List<AccessModesEnum> accessModes) {
    this.accessModes = accessModes;
  }

  public PersistentVolume nfsPath(String nfsPath) {
    this.nfsPath = nfsPath;
    return this;
  }

   /**
   * Get nfsPath
   * @return nfsPath
  **/
  @ApiModelProperty(value = "")
  public String getNfsPath() {
    return nfsPath;
  }

  public void setNfsPath(String nfsPath) {
    this.nfsPath = nfsPath;
  }

  public PersistentVolume nfsServer(String nfsServer) {
    this.nfsServer = nfsServer;
    return this;
  }

   /**
   * Get nfsServer
   * @return nfsServer
  **/
  @ApiModelProperty(value = "")
  public String getNfsServer() {
    return nfsServer;
  }

  public void setNfsServer(String nfsServer) {
    this.nfsServer = nfsServer;
  }

  public PersistentVolume reclaimPolicy(ReclaimPolicyEnum reclaimPolicy) {
    this.reclaimPolicy = reclaimPolicy;
    return this;
  }

   /**
   * Get reclaimPolicy
   * @return reclaimPolicy
  **/
  @ApiModelProperty(value = "")
  public ReclaimPolicyEnum getReclaimPolicy() {
    return reclaimPolicy;
  }

  public void setReclaimPolicy(ReclaimPolicyEnum reclaimPolicy) {
    this.reclaimPolicy = reclaimPolicy;
  }

  public PersistentVolume labels(Map<String, String> labels) {
    this.labels = labels;
    return this;
  }

  public PersistentVolume putLabelsItem(String key, String labelsItem) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersistentVolume persistentVolume = (PersistentVolume) o;
    return Objects.equals(this.id, persistentVolume.id) &&
        Objects.equals(this.name, persistentVolume.name) &&
        Objects.equals(this.capacity, persistentVolume.capacity) &&
        Objects.equals(this.accessModes, persistentVolume.accessModes) &&
        Objects.equals(this.nfsPath, persistentVolume.nfsPath) &&
        Objects.equals(this.nfsServer, persistentVolume.nfsServer) &&
        Objects.equals(this.reclaimPolicy, persistentVolume.reclaimPolicy) &&
        Objects.equals(this.labels, persistentVolume.labels);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, capacity, accessModes, nfsPath, nfsServer, reclaimPolicy, labels);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersistentVolume {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    capacity: ").append(toIndentedString(capacity)).append("\n");
    sb.append("    accessModes: ").append(toIndentedString(accessModes)).append("\n");
    sb.append("    nfsPath: ").append(toIndentedString(nfsPath)).append("\n");
    sb.append("    nfsServer: ").append(toIndentedString(nfsServer)).append("\n");
    sb.append("    reclaimPolicy: ").append(toIndentedString(reclaimPolicy)).append("\n");
    sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
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

