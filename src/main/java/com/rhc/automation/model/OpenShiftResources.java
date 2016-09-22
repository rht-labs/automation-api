package com.rhc.automation.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * OpenShiftResources
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-19T17:04:30.676-07:00")

public class OpenShiftResources {
    private Long id = null;

    private List<Project> projects = new ArrayList<Project>();

    public OpenShiftResources id(Long id) {
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

    public OpenShiftResources projects(List<Project> projects) {
        this.projects = projects;
        return this;
    }

    public OpenShiftResources addProjectsItem(Project projectsItem) {
        this.projects.add(projectsItem);
        return this;
    }

    /**
     * Get projects
     * 
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
        OpenShiftResources openShiftResources = (OpenShiftResources) o;
        return Objects.equals(this.id, openShiftResources.id)
                && Objects.equals(this.projects, openShiftResources.projects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projects);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OpenShiftResources {\n");

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
