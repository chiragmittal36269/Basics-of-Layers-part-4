package com.developer.StudentTeacherManagement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add-student")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return new ResponseEntity<>("New Student added Successfully", HttpStatus.CREATED);
    }

    @PostMapping("/add-teacher")
    public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher) {
        studentService.addTeacher(teacher);
        return new ResponseEntity<>("New Teacher added Successfully", HttpStatus.CREATED);
    }

    @PutMapping("/add-student-teacher-pair")
    public ResponseEntity<String> addStudentTeacherPair(@RequestParam("student") String student, @RequestParam("teacher") String teacher) {
        studentService.addStudentTeacherPair(teacher, student);
        return new ResponseEntity<>("New Student-Teacher Pair added Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get-student")
    public ResponseEntity<Student> getStudentByName(@RequestParam("student") String student) {
        Student s = studentService.getStudentByName(student);
        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }


    @GetMapping("/get-teacher/{teacher}")
    public ResponseEntity<Teacher> getTeacherByName(@PathVariable String teacher) {
        Teacher t = studentService.getTeacherByName(teacher);
        return new ResponseEntity<>(t, HttpStatus.CREATED);
    }


    @GetMapping("/get-student-by-teacher-name/{teacher}")
    public ResponseEntity<List<String>> getStudentByTeacherName(@PathVariable("teacher") String teacher) {
        List<String> student = studentService.getStudentByTeacherName(teacher);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }


    @GetMapping("/get_all-students")
    public ResponseEntity<List<String>> getAllStudent() {
        List<String> student = studentService.getAllStudent();
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }


    @DeleteMapping("delete-teacher-by-name")
    public ResponseEntity<String> deleteTeacherByName(@RequestParam("teacher") String teacher) {
        studentService.deleteTeacherByName(teacher);
        return new ResponseEntity<>(teacher + " deleted Successfully", HttpStatus.CREATED);
    }


    @DeleteMapping("delete-all-teachers")
    public ResponseEntity<String> deleteAllTeacher() {
        studentService.deleteAllTeacher();
        return new ResponseEntity<>("All Teachers Deleted Successfully", HttpStatus.CREATED);
    }
}