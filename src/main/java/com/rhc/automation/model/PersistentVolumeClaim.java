package com.rhc.automation.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;




/**
 * PersistentVolumeClaim
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-12T13:59:49.822-08:00")

public class PersistentVolumeClaim   {
  private Long id = null;

  private String name = null;

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

  private Long storage = null;

  private LabelSelector selector = null;

  public PersistentVolumeClaim id(Long id) {
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

  public PersistentVolumeClaim name(String name) {
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

  public PersistentVolumeClaim accessModes(List<AccessModesEnum> accessModes) {
    this.accessModes = accessModes;
    return this;
  }

  public PersistentVolumeClaim addAccessModesItem(AccessModesEnum accessModesItem) {
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

  public PersistentVolumeClaim storage(Long storage) {
    this.storage = storage;
    return this;
  }

   /**
   * Get storage
   * @return storage
  **/
  @ApiModelProperty(value = "")
  public Long getStorage() {
    return storage;
  }

  public void setStorage(Long storage) {
    this.storage = storage;
  }

  public PersistentVolumeClaim selector(LabelSelector selector) {
    this.selector = selector;
    return this;
  }

   /**
   * Get selector
   * @return selector
  **/
  @ApiModelProperty(value = "")
  public LabelSelector getSelector() {
    return selector;
  }

  public void setSelector(LabelSelector selector) {
    this.selector = selector;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersistentVolumeClaim persistentVolumeClaim = (PersistentVolumeClaim) o;
    return Objects.equals(this.id, persistentVolumeClaim.id) &&
        Objects.equals(this.name, persistentVolumeClaim.name) &&
        Objects.equals(this.accessModes, persistentVolumeClaim.accessModes) &&
        Objects.equals(this.storage, persistentVolumeClaim.storage) &&
        Objects.equals(this.selector, persistentVolumeClaim.selector);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, accessModes, storage, selector);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersistentVolumeClaim {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    accessModes: ").append(toIndentedString(accessModes)).append("\n");
    sb.append("    storage: ").append(toIndentedString(storage)).append("\n");
    sb.append("    selector: ").append(toIndentedString(selector)).append("\n");
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

