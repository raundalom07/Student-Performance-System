package com.om.backend.dto;

import jakarta.validation.constraints.*;

public class StudentRequestDTO {

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50)
    private String name;

    @NotNull
    @Min(0)
    @Max(24)
    private Double studyHours;

    @NotNull
    @Min(0)
    @Max(100)
    private Integer attendance;

    @NotNull
    @Min(0)
    @Max(100)
    private Double internalMarks;

    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("10.0")
    private Double previousCgpa;

    // Getters and Setters
    public String getName() { return name; }
    public Double getStudyHours() { return studyHours; }
    public Integer getAttendance() { return attendance; }
    public Double getInternalMarks() { return internalMarks; }
    public Double getPreviousCgpa() { return previousCgpa; }

    public void setName(String name) { this.name = name; }
    public void setStudyHours(Double studyHours) { this.studyHours = studyHours; }
    public void setAttendance(Integer attendance) { this.attendance = attendance; }
    public void setInternalMarks(Double internalMarks) { this.internalMarks = internalMarks; }
    public void setPreviousCgpa(Double previousCgpa) { this.previousCgpa = previousCgpa; }
}
