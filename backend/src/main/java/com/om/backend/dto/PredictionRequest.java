package com.om.backend.dto;

public class PredictionRequest {

    private double studyHours;
    private int attendance;
    private double internalMarks;
    private double previousCgpa;

    public double getStudyHours() { return studyHours; }
    public void setStudyHours(double studyHours) { this.studyHours = studyHours; }

    public int getAttendance() { return attendance; }
    public void setAttendance(int attendance) { this.attendance = attendance; }

    public double getInternalMarks() { return internalMarks; }
    public void setInternalMarks(double internalMarks) { this.internalMarks = internalMarks; }

    public double getPreviousCgpa() { return previousCgpa; }
    public void setPreviousCgpa(double previousCgpa) { this.previousCgpa = previousCgpa; }
}
