package com.rhc.automation.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.joda.time.LocalDate;

import io.swagger.annotations.ApiModelProperty;

/**
 * Engagement
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-19T17:04:30.676-07:00")

public class Engagement implements AutomationModel {
    private Long id = null;

    private String name = null;

    private LocalDate startDate = null;

    private LocalDate endDate = null;

    private List<OpenShiftCluster> openShiftClusters = new ArrayList<OpenShiftCluster>();

    private List<User> team = new ArrayList<User>();

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

    public Engagement openShiftClusters(List<OpenShiftCluster> openShiftClusters) {
        this.openShiftClusters = openShiftClusters;
        return this;
    }

    public Engagement addOpenShiftClustersItem(OpenShiftCluster openShiftClustersItem) {
        this.openShiftClusters.add(openShiftClustersItem);
        return this;
    }

    /**
     * Get openShiftClusters
     * 
     * @return openShiftClusters
     **/
    @ApiModelProperty(value = "")
    public List<OpenShiftCluster> getOpenShiftClusters() {
        return openShiftClusters;
    }

    public void setOpenShiftClusters(List<OpenShiftCluster> openShiftClusters) {
        this.openShiftClusters = openShiftClusters;
    }

    public Engagement team(List<User> team) {
        this.team = team;
        return this;
    }

    public Engagement addTeamItem(User teamItem) {
        this.team.add(teamItem);
        return this;
    }

    /**
     * Get team
     * 
     * @return team
     **/
    @ApiModelProperty(value = "")
    public List<User> getTeam() {
        return team;
    }

    public void setTeam(List<User> team) {
        this.team = team;
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
                && Objects.equals(this.openShiftClusters, engagement.openShiftClusters)
                && Objects.equals(this.team, engagement.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, startDate, endDate, openShiftClusters, team);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Engagement {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
        sb.append("    openShiftClusters: ").append(toIndentedString(openShiftClusters)).append("\n");
        sb.append("    team: ").append(toIndentedString(team)).append("\n");
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
