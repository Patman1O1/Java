package com.gradecalc;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.*;

@JsonSerialize(using = CourseSerializer.class)
@JsonIgnoreProperties({"grade"})
public class Course {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    @JsonProperty("name")
    private String name;

    @JsonProperty("categories")
    private final Map<String, Category> categories;

    private final Map<String, Category> emptyCategories;

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    public Course() { this.name = ""; this.categories = new TreeMap<>(); this.emptyCategories = new TreeMap<>(); }

    public Course(String name) {
        this.setName(name);
        this.categories = new TreeMap<>();
        this.emptyCategories = new TreeMap<>();
    }

    public Course(String name, Iterable<Category> categories) throws NullPointerException {
        this.setName(name);
        this.categories = new TreeMap<>();
        this.emptyCategories = new TreeMap<>();
        this.setCategories(categories);
    }

    /* -------------------------------------------------Setters------------------------------------------------------ */
    public void setName(String name) { this.name = name != null ? name : ""; }

    public void setCategories(Iterable<Category> categories) throws NullPointerException {
        if (categories == null) {
            throw new NullPointerException("\"categories\" cannot be null");
        }

        this.categories.clear();
        this.emptyCategories.clear();
        for (Category category : categories) {
            this.addCategory(category);
        }
    }

    /* -------------------------------------------------Getters------------------------------------------------------ */
    public String getName() { return this.name; }

    public Iterable<Category> getCategories() { return this.categories.values(); }

    public Category getCategory(String categoryName) {
        if (categoryName == null) {
            return null;
        }

        return this.categories.get(categoryName);
    }

    /* -------------------------------------------------Methods------------------------------------------------------ */
    @Override
    public String toString() { return this.name; }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Course other)) {
            return false;
        }

        return this.name.equals(other.name) &&
                this.categories.equals(other.categories) &&
                this.emptyCategories.equals(other.emptyCategories);
    }

    public void addCategory(Category category) throws NullPointerException {
        if (category == null) {
            throw new NullPointerException("\"category\" cannot be null");
        }

        if (category.countItems() == 0) {
            this.emptyCategories.put(category.getName(), category);
        }

        this.categories.put(category.getName(), category);
    }

    public boolean removeCategory(Category category) {
        if (category == null || this.categories.isEmpty() || !this.categories.containsKey(category.getName())) {
            return false;
        }

        String categoryName = category.getName();
        this.emptyCategories.remove(categoryName);
        return this.categories.remove(categoryName) != null;
    }

    public boolean removeCategory(String categoryName) {
        if (categoryName == null || this.categories.isEmpty() || !this.categories.containsKey(categoryName)) {
            return false;
        }

        this.emptyCategories.remove(categoryName);
        return this.categories.remove(categoryName) != null;
    }

    public boolean containsCategory(Category category) {
        if (category == null) {
            return false;
        }

        String categoryName = category.getName();
        return this.categories.containsKey(categoryName) || this.emptyCategories.containsKey(categoryName);
    }

    public boolean containsCategory(String categoryName) {
        if (categoryName == null) {
            return false;
        }
        return this.categories.containsKey(categoryName);
    }

    public int countCategories() { return this.categories.size(); }

    public int countEmptyCategories() { return this.emptyCategories.size(); }

    public double calculateGrade() {
        if (this.categories.isEmpty()) {
            return 0.0;
        }

        // Create a local variable to store the sum of every category grade multiplied by its weight
        double weightedGradeSum = 0.0;
        double totalWeights = 0.0;

        // For each category in the course...
        for (Category category : this.categories.values()) {
            // If the category does not contain any items...
            if (this.emptyCategories.containsValue(category)) {
                continue;
            }

            // Sum the weighted grade of the current item with weighted grade sum
            double weight = category.getWeight();
            weightedGradeSum += category.getGrade() * weight;
            totalWeights += weight;
        }

        return weightedGradeSum / totalWeights;
    }

}
