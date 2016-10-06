package com.rhc.automation.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * LabelSelector
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-06T10:52:08.748-07:00")

public class LabelSelector {
    private Long id = null;
    
    private Map<String, String> matchLabels = new HashMap<String, String>();

    public LabelSelector matchLabels(Map<String, String> matchLabels) {
        this.matchLabels = matchLabels;
        return this;
    }

    public LabelSelector putMatchLabelsItem(String key, String matchLabelsItem) {
        this.matchLabels.put(key, matchLabelsItem);
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

    /**
     * Get matchLabels
     * 
     * @return matchLabels
     **/
    @ApiModelProperty(value = "")
    public Map<String, String> getMatchLabels() {
        return matchLabels;
    }

    public void setMatchLabels(Map<String, String> matchLabels) {
        this.matchLabels = matchLabels;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LabelSelector labelSelector = (LabelSelector) o;
        return Objects.equals(this.matchLabels, labelSelector.matchLabels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchLabels);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LabelSelector {\n");

        sb.append("    matchLabels: ").append(toIndentedString(matchLabels)).append("\n");
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
