package com.rhc.automation.model;

import io.swagger.annotations.ApiModelProperty;
import org.joda.time.LocalDate;

import java.util.Objects;


/**
 * EngagementSummary
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-12T13:59:49.822-08:00")

public class EngagementSummary {
    private Long id = null;

    private String name = null;

    private LocalDate startDate = null;

    private LocalDate endDate = null;

    public EngagementSummary() {
    }

    public EngagementSummary( Engagement engagement ) {
        this.id = engagement.getId();
        this.name = engagement.getName();
        this.startDate = engagement.getStartDate();
        this.endDate = engagement.getEndDate();
    }

    public boolean nameContainsSearchTerm( String searchTerm ) {
        return getName().toLowerCase().contains( searchTerm.toLowerCase() );
    }

    public EngagementSummary id( Long id ) {
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

    public void setId( Long id ) {
        this.id = id;
    }

    public EngagementSummary name( String name ) {
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

    public void setName( String name ) {
        this.name = name;
    }

    public EngagementSummary startDate( LocalDate startDate ) {
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

    public void setStartDate( LocalDate startDate ) {
        this.startDate = startDate;
    }

    public EngagementSummary endDate( LocalDate endDate ) {
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

    public void setEndDate( LocalDate endDate ) {
        this.endDate = endDate;
    }


    @Override
    public boolean equals( java.lang.Object o ) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        EngagementSummary engagementSummary = (EngagementSummary) o;
        return Objects.equals( this.id, engagementSummary.id ) &&
                Objects.equals( this.name, engagementSummary.name ) &&
                Objects.equals( this.startDate, engagementSummary.startDate ) &&
                Objects.equals( this.endDate, engagementSummary.endDate );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id, name, startDate, endDate );
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append( "class EngagementSummary {\n" );

        sb.append( "    id: " ).append( toIndentedString( id ) ).append( "\n" );
        sb.append( "    name: " ).append( toIndentedString( name ) ).append( "\n" );
        sb.append( "    startDate: " ).append( toIndentedString( startDate ) ).append( "\n" );
        sb.append( "    endDate: " ).append( toIndentedString( endDate ) ).append( "\n" );
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

