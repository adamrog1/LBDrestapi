package com.example.lbdrestapi.Controllers;

import com.example.lbdrestapi.Model.Student;
import com.example.lbdrestapi.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;




    @PutMapping("students/addStudent")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @PutMapping("students/edit/{id}/{newSurname}/{newAge}")
    public Student editStudent(@PathVariable Long id, @PathVariable String newSurname, @PathVariable int newAge){
        return studentService.editStudent(id,newSurname,newAge);
    }

    @PostMapping("/students/delete/{id}")
    public void deleteStudent(@PathVariable Long id){
    }


    @GetMapping("/students/getStudent/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .header("successful", "true")
                .body(studentService.getStudent(id));
    }
    @GetMapping("students/getall")
    public ResponseEntity<List<Student>> getStudentsAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .header("successful", "true")
                .body(studentService.getAllStudents());
    }
}
