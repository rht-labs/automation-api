package com.rhc.automation.model;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * User
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-19T17:04:30.676-07:00")

public class User implements AutomationModel {
    private Long id = null;

    private String email = null;

    private String firstName = null;

    private String lastName = null;

    private String userName = null;

    public User id(Long id) {
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

    public User email(String email) {
        this.email = email;
        return this;
    }

    /**
     * Get email
     * 
     * @return email
     **/
    @ApiModelProperty(required = true, value = "")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Get firstName
     * 
     * @return firstName
     **/
    @ApiModelProperty(value = "")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public User lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Get lastName
     * 
     * @return lastName
     **/
    @ApiModelProperty(value = "")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User userName(String userName) {
        this.userName = userName;
        return this;
    }

    /**
     * Get userName
     * 
     * @return userName
     **/
    @ApiModelProperty(required = true, value = "")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(this.id, user.id) && Objects.equals(this.email, user.email)
                && Objects.equals(this.firstName, user.firstName) && Objects.equals(this.lastName, user.lastName)
                && Objects.equals(this.userName, user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, firstName, lastName, userName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class User {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
        sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
        sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
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
