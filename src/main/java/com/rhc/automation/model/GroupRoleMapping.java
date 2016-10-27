package com.rhc.automation.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * GroupRoleMapping
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-20T10:15:11.431-07:00")

public class GroupRoleMapping {
    private Long id = null;

    private Group group = null;

    private List<Role> roles = new ArrayList<Role>();

    public GroupRoleMapping id(Long id) {
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

    public GroupRoleMapping group(Group group) {
        this.group = group;
        return this;
    }

    /**
     * Get user
     * 
     * @return user
     **/
    @ApiModelProperty(required = true, value = "")
    public Group getGroup() {
        return group;
    }

    public void setUser(Group group) {
        this.group = group;
    }

    public GroupRoleMapping roles(List<Role> roles) {
        this.roles = roles;
        return this;
    }

    public GroupRoleMapping addRolesItem(Role rolesItem) {
        this.roles.add(rolesItem);
        return this;
    }

    /**
     * Get roles
     * 
     * @return roles
     **/
    @ApiModelProperty(required = true, value = "")
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GroupRoleMapping groupRoleMapping = (GroupRoleMapping) o;
        return Objects.equals(this.id, groupRoleMapping.id) && Objects.equals(this.group, groupRoleMapping.group)
                && Objects.equals(this.roles, groupRoleMapping.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, group, roles);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GroupRoleMapping {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    group: ").append(toIndentedString(group)).append("\n");
        sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
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
