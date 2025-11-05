package com.gradecalc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.gradecalc.io.ItemDeserializer;
import com.gradecalc.io.ItemSerializer;

@JsonSerialize(using = ItemSerializer.class)
@JsonDeserialize(using = ItemDeserializer.class)
public class Item {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    private static final double EPSILON = 1.0e-10;

    @JsonProperty("name")
    private String name;

    @JsonProperty("earnedPoints")
    private double earnedPoints;

    @JsonProperty("totalPoints")
    private double totalPoints;

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    public Item() { this.name = ""; this.earnedPoints = 0.0; this.totalPoints = 1.0; }

    public Item(String name, double earnedPoints) throws IllegalArgumentException {
        this.setName(name);
        this.setEarnedPoints(earnedPoints);
        this.setTotalPoints(100.0);
    }

    public Item(String name, double earnedPoints, double totalPoints) throws IllegalArgumentException {
        this.setName(name);
        this.setEarnedPoints(earnedPoints);
        this.setTotalPoints(totalPoints);
    }

    /* -------------------------------------------------Setters------------------------------------------------------ */
    public void setName(String name) { this.name = name != null ? name : ""; }

    public void setEarnedPoints(double earnedPoints) throws IllegalArgumentException {
        if (earnedPoints < 0.0) {
            throw new IllegalArgumentException("\"earnedPoints\" cannot be negative");
        }

        this.earnedPoints = earnedPoints;
    }

    public void setTotalPoints(double totalPoints) throws IllegalArgumentException {
        if (totalPoints < 0.0 || doubleEquals(totalPoints, 0.0)) {
            throw new IllegalArgumentException("\"totalPoints\" cannot be non-positive");
        }

        this.totalPoints = totalPoints;
    }

    /* -------------------------------------------------Getters------------------------------------------------------ */
    public String getName() { return this.name; }

    public double getEarnedPoints() { return this.earnedPoints; }

    public double getTotalPoints() { return this.totalPoints; }

    /* -------------------------------------------------Methods------------------------------------------------------ */
    private static boolean doubleEquals(double lhs, double rhs) { return Math.abs(lhs - rhs) < EPSILON; }

    @Override
    public String toString() { return this.name; }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Item other)) {
            return false;
        }

        return this.name.equals(other.name) && doubleEquals(this.calculateGrade(), other.calculateGrade());
    }

    public double calculateGrade() { return this.earnedPoints / this.totalPoints; }

    public int compareTo(Item other) throws NullPointerException {
        if (other == null) {
            throw new NullPointerException("\"other\" cannot be null");
        }

        double thisGrade = this.calculateGrade();
        double otherGrade = other.calculateGrade();

        if (doubleEquals(thisGrade, otherGrade)) {
            return 0;
        }

        if (thisGrade > otherGrade) {
            return 1;
        }

        return -1;
    }

}
