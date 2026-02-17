package com.om.backend.dto;

public class PredictionResponse {

    private double predictedScore;
    private String performanceLevel;

    public PredictionResponse(double predictedScore, String performanceLevel) {
        this.predictedScore = predictedScore;
        this.performanceLevel = performanceLevel;
    }

    public double getPredictedScore() { return predictedScore; }
    public String getPerformanceLevel() { return performanceLevel; }
}
