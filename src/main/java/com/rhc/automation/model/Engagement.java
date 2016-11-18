package com.rhc.automation.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.joda.time.LocalDate;

import io.swagger.annotations.ApiModelProperty;

/**
 * Engagement
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-05T12:23:04.865-07:00")

public class Engagement implements AutomationModel {
    private Long id = null;

    private String name = null;

    private LocalDate startDate = null;

    private LocalDate endDate = null;

    private List<OpenShiftCluster> openshiftClusters = new ArrayList<OpenShiftCluster>();

    private List<User> users = new ArrayList<User>();
    
    private List<Group> groups = new ArrayList<Group>();

    public Engagement id(Long id) {
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

    public Engagement name(String name) {
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

    public Engagement startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Get startDate
     * 
     * @return startDate
     **/
    @ApiModelProperty(value = "")
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Engagement endDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Get endDate
     * 
     * @return endDate
     **/
    @ApiModelProperty(value = "")
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Engagement openshiftClusters(List<OpenShiftCluster> openshiftClusters) {
        this.openshiftClusters = openshiftClusters;
        return this;
    }

    public Engagement addOpenshiftClustersItem(OpenShiftCluster openshiftClustersItem) {
        this.openshiftClusters.add(openshiftClustersItem);
        return this;
    }

    /**
     * Get openshiftClusters
     * 
     * @return openshiftClusters
     **/
    @ApiModelProperty(value = "")
    public List<OpenShiftCluster> getOpenshiftClusters() {
        return openshiftClusters;
    }

    public void setOpenshiftClusters(List<OpenShiftCluster> openshiftClusters) {
        this.openshiftClusters = openshiftClusters;
    }

    public Engagement users(List<User> users) {
        this.users = users;
        return this;
    }

    public Engagement addUsersItem(User usersItem) {
        this.users.add(usersItem);
        return this;
    }

    /**
     * Get users
     * 
     * @return users
     **/
    @ApiModelProperty(value = "")
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    public Engagement groups(List<Group> groups) {
        this.groups = groups;
        return this;
    }

    public Engagement addGroupsItem(Group groupsItem) {
        this.groups.add(groupsItem);
        return this;
    }

    /**
     * Get groups
     * 
     * @return groups
     **/
    @ApiModelProperty(value = "")
    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Engagement engagement = (Engagement) o;
        return Objects.equals(this.id, engagement.id) && Objects.equals(this.name, engagement.name)
                && Objects.equals(this.startDate, engagement.startDate)
                && Objects.equals(this.endDate, engagement.endDate)
                && Objects.equals(this.openshiftClusters, engagement.openshiftClusters)
                && Objects.equals(this.users, engagement.users) && Objects.equals(this.groups, engagement.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, startDate, endDate, openshiftClusters, users, groups);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Engagement {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
        sb.append("    openshiftClusters: ").append(toIndentedString(openshiftClusters)).append("\n");
        sb.append("    users: ").append(toIndentedString(users)).append("\n");
        sb.append("    groups: ").append(toIndentedString(groups)).append("\n");
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
