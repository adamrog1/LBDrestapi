package com.example.lbdrestapi.Controllers;

import com.example.lbdrestapi.Model.Student;
import com.example.lbdrestapi.Model.Subjects;
import com.example.lbdrestapi.Model.Teacher;
import com.example.lbdrestapi.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/teachers/getAll")
    public List<Teacher> getAll(){
        return teacherService.getAllTeachers();
    }

    @PostMapping("/teachers/addTeacher")
    public Teacher addTeacher(@RequestBody Teacher teacher){
        return teacherService.addTeacher(teacher);
    }

    @PostMapping("/teachers/delete/{id}")
    public void deleteTeacher(@PathVariable Long id){
        teacherService.deleteTeacher(id);
    }

    @GetMapping("/teachers/get/{id}")
    public Teacher getTeacher(@PathVariable Long id){
        return teacherService.getTeacher(id);
    }

    @GetMapping("/teachers/getTeacherClass/{id}")
    public List<Student> getTeacherClass(@PathVariable Long id){
        return teacherService.getTeacherClass(id);
    }

    @PostMapping("/teachers/deleteStudentFromClassByTeacherId/{teacher_id}/{student_id}")
    public void deleteStudentFromClassByTeacherId(@PathVariable Long teacher_id, @PathVariable Long student_id){
        teacherService.deleteStudentFromClassByTeacherId(teacher_id,student_id);
    }


}
