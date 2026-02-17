package com.om.backend.service;

import com.om.backend.model.Student;
import com.om.backend.repository.StudentRepository;
import com.om.backend.dto.PredictionRequest;
import com.om.backend.dto.PredictionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.om.backend.exception.ResourceNotFoundException;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // ===================== CREATE =====================
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // ===================== READ ALL =====================
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // ===================== READ BY ID =====================
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    }

    // ===================== UPDATE =====================
    public Student updateStudent(Long id, Student updatedStudent) {
        Student student = getStudentById(id);

        student.setName(updatedStudent.getName());
        student.setAttendance(updatedStudent.getAttendance());
        student.setInternalMarks(updatedStudent.getInternalMarks());
        student.setStudyHours(updatedStudent.getStudyHours());
        student.setPreviousCgpa(updatedStudent.getPreviousCgpa());

        return studentRepository.save(student);
    }

    // ===================== DELETE =====================
    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
    }

    // ===================== PREDICTION LOGIC =====================
    public PredictionResponse predictPerformance(PredictionRequest request) {

        // Simple weighted formula (mock AI logic)
        double predictedScore =
                (request.getStudyHours() * 5) +
                (request.getAttendance() * 0.3) +
                (request.getInternalMarks() * 0.4) +
                (request.getPreviousCgpa() * 5);

        String performanceLevel;

        if (predictedScore >= 85) {
            performanceLevel = "Excellent";
        } else if (predictedScore >= 70) {
            performanceLevel = "Good";
        } else if (predictedScore >= 50) {
            performanceLevel = "Average";
        } else {
            performanceLevel = "Poor";
        }

        return new PredictionResponse(predictedScore, performanceLevel);
    }
}
