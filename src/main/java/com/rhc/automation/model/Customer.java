package com.rhc.automation.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * Customer
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-19T17:04:30.676-07:00")

public class Customer implements AutomationModel {
    private Long id = null;

    private String name = null;

    private List<Engagement> engagements = new ArrayList<Engagement>();

    public Customer id(Long id) {
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

    public Customer name(String name) {
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

    public Customer engagements(List<Engagement> engagements) {
        this.engagements = engagements;
        return this;
    }

    public Customer addEngagementsItem(Engagement engagementsItem) {
        this.engagements.add(engagementsItem);
        return this;
    }

    /**
     * Get engagements
     * 
     * @return engagements
     **/
    @ApiModelProperty(value = "")
    public List<Engagement> getEngagements() {
        return engagements;
    }

    public void setEngagements(List<Engagement> engagements) {
        this.engagements = engagements;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Customer customer = (Customer) o;
        return Objects.equals(this.id, customer.id) && Objects.equals(this.name, customer.name)
                && Objects.equals(this.engagements, customer.engagements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, engagements);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Customer {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    engagements: ").append(toIndentedString(engagements)).append("\n");
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
