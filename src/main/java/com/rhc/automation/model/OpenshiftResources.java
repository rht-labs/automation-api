package com.rhc.automation.model;

import java.util.Objects;
import com.rhc.automation.model.Project;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;




/**
 * OpenshiftResources
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-08T13:44:26.455-07:00")

public class OpenshiftResources   {
  private Long id = null;

  private List<Project> projects = new ArrayList<Project>();

  public OpenshiftResources id(Long id) {
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

  public OpenshiftResources projects(List<Project> projects) {
    this.projects = projects;
    return this;
  }

  public OpenshiftResources addProjectsItem(Project projectsItem) {
    this.projects.add(projectsItem);
    return this;
  }

   /**
   * Get projects
   * @return projects
  **/
  @ApiModelProperty(value = "")
  public List<Project> getProjects() {
    return projects;
  }

  public void setProjects(List<Project> projects) {
    this.projects = projects;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OpenshiftResources openshiftResources = (OpenshiftResources) o;
    return Objects.equals(this.id, openshiftResources.id) &&
        Objects.equals(this.projects, openshiftResources.projects);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, projects);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OpenshiftResources {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    projects: ").append(toIndentedString(projects)).append("\n");
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

