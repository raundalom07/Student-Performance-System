package com.om.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotNull(message = "Study hours is required")
    @Min(value = 0, message = "Study hours cannot be negative")
    @Max(value = 24, message = "Study hours cannot exceed 24 hours")
    private Double studyHours;

    @NotNull(message = "Attendance is required")
    @Min(value = 0, message = "Attendance cannot be less than 0")
    @Max(value = 100, message = "Attendance cannot exceed 100")
    private Integer attendance;

    @NotNull(message = "Internal marks is required")
    @Min(value = 0, message = "Internal marks cannot be less than 0")
    @Max(value = 100, message = "Internal marks cannot exceed 100")
    private Double internalMarks;

    @NotNull(message = "Previous CGPA is required")
    @DecimalMin(value = "0.0", message = "CGPA cannot be less than 0")
    @DecimalMax(value = "10.0", message = "CGPA cannot exceed 10")
    private Double previousCgpa;

    // ===== Constructors =====

    public Student() {
    }

    public Student(Long id, String name, Double studyHours, Integer attendance,
                   Double internalMarks, Double previousCgpa) {
        this.id = id;
        this.name = name;
        this.studyHours = studyHours;
        this.attendance = attendance;
        this.internalMarks = internalMarks;
        this.previousCgpa = previousCgpa;
    }

    // ===== Getters and Setters =====

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getStudyHours() {
        return studyHours;
    }

    public Integer getAttendance() {
        return attendance;
    }

    public Double getInternalMarks() {
        return internalMarks;
    }

    public Double getPreviousCgpa() {
        return previousCgpa;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudyHours(Double studyHours) {
        this.studyHours = studyHours;
    }

    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }

    public void setInternalMarks(Double internalMarks) {
        this.internalMarks = internalMarks;
    }

    public void setPreviousCgpa(Double previousCgpa) {
        this.previousCgpa = previousCgpa;
    }
}
