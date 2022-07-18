package com.example.lbdrestapi.Controllers;

import com.example.lbdrestapi.Model.Student;
import com.example.lbdrestapi.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students/getAll")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

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
    public Student getStudent(@PathVariable Long id){
        return studentService.getStudent(id);
    }
}
