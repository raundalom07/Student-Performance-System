package com.om.backend.controller;

import com.om.backend.dto.ApiResponse;
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

import org.springframework.data.domain.Page;

import jakarta.validation.Valid;

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

        Student student = new Student();
        student.setName(request.getName());
        student.setStudyHours(request.getStudyHours());
        student.setAttendance(request.getAttendance());
        student.setInternalMarks(request.getInternalMarks());
        student.setPreviousCgpa(request.getPreviousCgpa());

        Student saved = studentService.saveStudent(student);

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

    // ===================== READ WITH PAGINATION =====================
    @GetMapping
    public ResponseEntity<ApiResponse<Page<Student>>> getStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy) {

        Page<Student> studentsPage =
                studentService.getStudentsWithPagination(page, size, sortBy);

        ApiResponse<Page<Student>> response =
                new ApiResponse<>(true, "Students fetched successfully", studentsPage);

        return ResponseEntity.ok(response);
    }

    // ===================== READ BY ID =====================
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getStudentById(@PathVariable Long id) {

        Student student = studentService.getStudentById(id);

        ApiResponse<Student> response =
                new ApiResponse<>(true, "Student fetched successfully", student);

        return ResponseEntity.ok(response);
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
    public ResponseEntity<ApiResponse<Void>> deleteStudent(@PathVariable Long id) {

        studentService.deleteStudent(id);

        ApiResponse<Void> response =
                new ApiResponse<>(true, "Student deleted successfully", null);

        return ResponseEntity.ok(response);
    }
}
