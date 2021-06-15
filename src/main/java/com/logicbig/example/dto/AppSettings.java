package com.logicbig.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class AppSettings {

    @JsonProperty("_id")
    private String id;

    /**
     * The category.
     */
    private String category;

    /**
     * The sub category.
     */
    private String subCategory;

    /**
     * The display name.
     */
    private String displayName;

    /**
     * The properties.
     */
    private Map<String, Object> properties;

    /**
     * Gets the category.
     *
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category.
     *
     * @param category the new category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets the sub category.
     *
     * @return the sub category
     */
    public String getSubCategory() {
        return subCategory;
    }

    /**
     * Sets the sub category.
     *
     * @param subCategory the new sub category
     */
    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    /**
     * Gets the display name.
     *
     * @return the display name
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets the display name.
     *
     * @param displayName the new display name
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Gets the properties.
     *
     * @return the properties
     */
    public Map<String, Object> getProperties() {
        return properties;
    }

    /**
     * Sets the properties.
     *
     * @param properties the properties
     */
    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

   /* @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AppSettings [category=");
        builder.append(category);
        builder.append(", subCategory=");
        builder.append(subCategory);
        builder.append("]");
        return builder.toString();
    }*/

    @Override
    public String toString() {
        return "AppSettings{" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                ", subCategory='" + subCategory + '\'' +
                ", displayName='" + displayName + '\'' +
                ", properties=" + properties +
                '}';
    }
}
