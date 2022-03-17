package ch.supsi.assignment2.controller;

import ch.supsi.assignment2.model.Student;
import ch.supsi.assignment2.view.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        try {
            List<Student> students = new ArrayList<>();
            studentRepository.findAll().forEach(students::add);
            if (students.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(Student student){
        try {
            if(studentRepository.existsByEmail(student.getEmail()))
                return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
            Student createdUser = studentRepository.save(
                    new Student(student.getName(),student.getLastname(), student.getEmail(), student.getCourses()));
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/students/{email}")
    public ResponseEntity<Student> getStudentByEmail(@PathVariable("email") String email) {
        try {
            if (studentRepository.existsByEmail(email))
                return new ResponseEntity<>(studentRepository.findByEmail(email), HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/students/{email}")
    public ResponseEntity<Student> removeStudent(@PathVariable("email") String email) {
        try {
            if (studentRepository.existsByEmail(email)) {
                Student deletedStudent = studentRepository.findByEmail(email);
                studentRepository.delete(deletedStudent);
                return new ResponseEntity<>(deletedStudent, HttpStatus.OK);
            }else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
