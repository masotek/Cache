package com.infoshareacademy.locator.model;

import javax.json.bind.annotation.JsonbProperty;

public class Earthquake {
    private String id;
    private String origin;
    private double magnitude;
    private double depth;
    private String solution;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    @JsonbProperty("origin_time")
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getMagnitude() {
        return magnitude;
    }

    @JsonbProperty("magnitude")
    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public double getDepth() {
        return depth;
    }

    @JsonbProperty("depth")
    public void setDepth(double depth) {
        this.depth = depth;
    }

    public String getSolution() {
        return solution;
    }

    @JsonbProperty("solution_id")
    public void setSolution(String solution) {
        this.solution = solution;
    }
}
