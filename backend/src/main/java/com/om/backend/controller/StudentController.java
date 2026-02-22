package com.om.backend.controller;

import com.om.backend.model.Student;
import com.om.backend.service.StudentService;
import com.om.backend.dto.PredictionRequest;
import com.om.backend.dto.PredictionResponse;
import com.om.backend.dto.StudentRequestDTO;
import com.om.backend.dto.StudentResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    // ===================== CREATE =====================
    @PostMapping
    public ResponseEntity<StudentResponseDTO> createStudent(
            @Valid @RequestBody StudentRequestDTO request) {

        // Convert DTO → Entity
        Student student = new Student();
        student.setName(request.getName());
        student.setStudyHours(request.getStudyHours());
        student.setAttendance(request.getAttendance());
        student.setInternalMarks(request.getInternalMarks());
        student.setPreviousCgpa(request.getPreviousCgpa());

        // Save to DB
        Student saved = studentService.saveStudent(student);

        // Convert Entity → DTO
        StudentResponseDTO response = new StudentResponseDTO(
                saved.getId(),
                saved.getName(),
                saved.getStudyHours(),
                saved.getAttendance(),
                saved.getInternalMarks(),
                saved.getPreviousCgpa()
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // ===================== PREDICT =====================
    @PostMapping("/predict")
    public PredictionResponse predict(@RequestBody PredictionRequest request) {
        return studentService.predictPerformance(request);
    }

    // ===================== READ ALL =====================
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // ===================== READ BY ID =====================
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    // ===================== UPDATE =====================
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody Student student) {

        Student updated = studentService.updateStudent(id, student);
        return ResponseEntity.ok(updated);
    }

    // ===================== DELETE =====================
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "Student deleted successfully";
    }
}
