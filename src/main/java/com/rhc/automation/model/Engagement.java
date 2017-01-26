package com.rhc.automation.model;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * Engagement uses annotations because it realizes on Hibernate Features, not pure JPA like the other entities
 */
@javax.annotation.Generated( value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-12T13:59:49.822-08:00" )

@Entity
public class Engagement {


    @Id
    @GenericGenerator( name = "custom_generator", strategy = "com.rhc.automation.repo.IdKeepingSequenceGenerator" )
    @GeneratedValue( generator = "custom_generator" )
    private Long id = null;

    private String name = null;

    private LocalDate startDate = null;

    private LocalDate endDate = null;

    @OneToMany( fetch = FetchType.EAGER, cascade = CascadeType.ALL )
    @Fetch( value = FetchMode.SELECT )
    private List<OpenShiftCluster> openshiftClusters = new ArrayList<OpenShiftCluster>();

    @ManyToMany( fetch = FetchType.EAGER, cascade = CascadeType.ALL )
    @Fetch( value = FetchMode.SELECT )
    private List<User> users = new ArrayList<User>();

    @ManyToMany( fetch = FetchType.EAGER, cascade = CascadeType.ALL )
    @Fetch( value = FetchMode.SELECT )
    @JoinTable( name = "engagement_groups", inverseJoinColumns = { @JoinColumn( name = "groups_id" ) } )
    private List<Group> userGroups = new ArrayList<Group>();

    public Engagement id( Long id ) {
        this.id = id;
        return this;
    }

    public boolean nameContainsSearchTerm( String searchTerm ) {
        return getName().toLowerCase().contains( searchTerm.toLowerCase() );
    }

    /**
     * If this is written as isValid, Jackson thinks its part of the Java Bean... TODO clean that up
     *
     * @return
     */
    public boolean determineIfValid() {
        return determineInvalidFields().size() == 0 ? true : false;
    }

    /**
     * If this is written as getInvalidFields, Jackson thinks its part of the Java Bean... TODO clean that up
     *
     * @return
     */
    public List<String> determineInvalidFields() {
        List<String> invalidFields = new ArrayList<>();
        if ( id == null ) {
            invalidFields.add( "id is null" );
        }
        if ( id != null && id < 0 ) {
            invalidFields.add( "id is negative" );
        }
        if ( name == null || name.isEmpty() ) {
            invalidFields.add( "name is null or empty" );
        }
        return invalidFields;
    }

    public Application getApplicationFromBuildProject( final String applicationName ) {
        for ( OpenShiftCluster cluster : getOpenshiftClusters() ) {
            for ( Project project : cluster.getOpenshiftResources().getProjects() ) {
                if ( project.getEnvironmentType().equals( Project.EnvironmentTypeEnum.BUILD ) ) {
                    for ( Application app : project.getApps() ) {
                        if ( app.getName() != null && app.getName().equals( applicationName ) ) {
                            return app;
                        }
                    }
                }
            }
        }
        return null;
    }

    public Project getBuildProjectForApplication( final String applicationName ) {
        for ( OpenShiftCluster cluster : getOpenshiftClusters() ) {
            for ( Project project : cluster.getOpenshiftResources().getProjects() ) {
                if ( project.getEnvironmentType().equals( Project.EnvironmentTypeEnum.BUILD ) ) {
                    for ( Application app : project.getApps() ) {
                        if ( app.getName() != null && app.getName().equals( applicationName ) ) {
                            return project;
                        }
                    }
                }
            }
        }
        return null;
    }

    public List<Project> getPromotionProjectsForApplication( final String applicationName ) {
        List<Project> projects = new ArrayList<>();

        for ( OpenShiftCluster cluster : getOpenshiftClusters() ) {
            for ( Project project : cluster.getOpenshiftResources().getProjects() ) {
                if ( project.getEnvironmentType().equals( Project.EnvironmentTypeEnum.PROMOTION ) ) {
                    for ( Application app : project.getApps() ) {
                        if ( app.getName() != null && app.getName().equals( applicationName ) ) {
                            projects.add( project );
                        }
                    }
                }
            }
        }
        return projects;
    }

    /**
     * There should only be a single build project declared across all clusters. It is invalid to have more than one.
     */
    public OpenShiftCluster getClusterWithBuildProject() {
        for ( OpenShiftCluster cluster : getOpenshiftClusters() ) {
            for ( Project project : cluster.getOpenshiftResources().getProjects() ) {
                if ( project.getEnvironmentType().equals( Project.EnvironmentTypeEnum.BUILD ) ) {
                    return cluster;
                }
            }
        }
        return null;
    }

    public OpenShiftCluster getBuildCluster() {
        return getOpenshiftClusters().get( 0 );
    }

    /**
     * Get id
     *
     * @return id
     **/
    @ApiModelProperty( required = true, value = "" )
    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public Engagement name( String name ) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    @ApiModelProperty( required = true, value = "" )
    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public Engagement startDate( LocalDate startDate ) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Get startDate
     *
     * @return startDate
     **/
    @ApiModelProperty( value = "" )
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate( LocalDate startDate ) {
        this.startDate = startDate;
    }

    public Engagement endDate( LocalDate endDate ) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Get endDate
     *
     * @return endDate
     **/
    @ApiModelProperty( value = "" )
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate( LocalDate endDate ) {
        this.endDate = endDate;
    }

    public Engagement openshiftClusters( List<OpenShiftCluster> openshiftClusters ) {
        this.openshiftClusters = openshiftClusters;
        return this;
    }

    public Engagement addOpenshiftClustersItem( OpenShiftCluster openshiftClustersItem ) {
        this.openshiftClusters.add( openshiftClustersItem );
        return this;
    }

    /**
     * Get openshiftClusters
     *
     * @return openshiftClusters
     **/
    @ApiModelProperty( value = "" )
    public List<OpenShiftCluster> getOpenshiftClusters() {
        return openshiftClusters;
    }

    public void setOpenshiftClusters( List<OpenShiftCluster> openshiftClusters ) {
        this.openshiftClusters = openshiftClusters;
    }

    public Engagement users( List<User> users ) {
        this.users = users;
        return this;
    }

    public Engagement addUsersItem( User usersItem ) {
        this.users.add( usersItem );
        return this;
    }

    /**
     * Get users
     *
     * @return users
     **/
    @ApiModelProperty( value = "" )
    public List<User> getUsers() {
        return users;
    }

    public void setUsers( List<User> users ) {
        this.users = users;
    }

    public Engagement userGroups( List<Group> userGroups ) {
        this.userGroups = userGroups;
        return this;
    }

    public Engagement addUserGroupsItem( Group userGroupsItem ) {
        this.userGroups.add( userGroupsItem );
        return this;
    }

    /**
     * Get userGroups
     *
     * @return userGroups
     **/
    @ApiModelProperty( value = "" )
    public List<Group> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups( List<Group> userGroups ) {
        this.userGroups = userGroups;
    }


    @Override
    public boolean equals( java.lang.Object o ) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        Engagement engagement = (Engagement) o;
        return Objects.equals( this.id, engagement.id ) &&
                Objects.equals( this.name, engagement.name ) &&
                Objects.equals( this.startDate, engagement.startDate ) &&
                Objects.equals( this.endDate, engagement.endDate ) &&
                Objects.equals( this.openshiftClusters, engagement.openshiftClusters ) &&
                Objects.equals( this.users, engagement.users ) &&
                Objects.equals( this.userGroups, engagement.userGroups );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id, name, startDate, endDate, openshiftClusters, users, userGroups );
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append( "class Engagement {\n" );

        sb.append( "    id: " ).append( toIndentedString( id ) ).append( "\n" );
        sb.append( "    name: " ).append( toIndentedString( name ) ).append( "\n" );
        sb.append( "    startDate: " ).append( toIndentedString( startDate ) ).append( "\n" );
        sb.append( "    endDate: " ).append( toIndentedString( endDate ) ).append( "\n" );
        sb.append( "    openshiftClusters: " ).append( toIndentedString( openshiftClusters ) ).append( "\n" );
        sb.append( "    users: " ).append( toIndentedString( users ) ).append( "\n" );
        sb.append( "    userGroups: " ).append( toIndentedString( userGroups ) ).append( "\n" );
        sb.append( "}" );
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString( java.lang.Object o ) {
        if ( o == null ) {
            return "null";
        }
        return o.toString().replace( "\n", "\n    " );
    }
}

