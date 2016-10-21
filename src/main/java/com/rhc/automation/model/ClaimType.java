package com.rhc.automation.model;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * ClaimType
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-06T10:52:08.748-07:00")

public class ClaimType {
    private Long id = null;

    /**
     * Gets or Sets kind
     */
    public enum KindEnum {
        SECRET("secret"),

        CLAIM("claim");

        private String value;

        KindEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    private KindEnum kind = null;

    private String name = null;

    public ClaimType id(Long id) {
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

    public ClaimType kind(KindEnum kind) {
        this.kind = kind;
        return this;
    }

    /**
     * Get kind
     * 
     * @return kind
     **/
    @ApiModelProperty(value = "")
    public KindEnum getKind() {
        return kind;
    }

    public void setKind(KindEnum kind) {
        this.kind = kind;
    }

    public ClaimType name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     * 
     * @return name
     **/
    @ApiModelProperty(value = "")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ClaimType claimType = (ClaimType) o;
        return Objects.equals(this.id, claimType.id) && Objects.equals(this.kind, claimType.kind)
                && Objects.equals(this.name, claimType.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, kind, name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ClaimType {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
