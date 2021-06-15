package com.logicbig.example.appviewxTest;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class AppSettings {
    @JsonProperty("_id")
    private String id;
    private String category;
    private String subCategory;
    private String displayName;
    private Map<String, Object> properties;

    public AppSettings() {
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return this.subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Map<String, Object> getProperties() {
        return this.properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AppSettings [category=");
        builder.append(this.category);
        builder.append(", subCategory=");
        builder.append(this.subCategory);
        builder.append("]");
        return builder.toString();
    }
}
