package com.om.backend.dto;

public class StudentResponseDTO {

    private Long id;
    private String name;
    private Double studyHours;
    private Integer attendance;
    private Double internalMarks;
    private Double previousCgpa;

    public StudentResponseDTO(Long id, String name, Double studyHours,
                              Integer attendance, Double internalMarks,
                              Double previousCgpa) {
        this.id = id;
        this.name = name;
        this.studyHours = studyHours;
        this.attendance = attendance;
        this.internalMarks = internalMarks;
        this.previousCgpa = previousCgpa;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public Double getStudyHours() { return studyHours; }
    public Integer getAttendance() { return attendance; }
    public Double getInternalMarks() { return internalMarks; }
    public Double getPreviousCgpa() { return previousCgpa; }
}

