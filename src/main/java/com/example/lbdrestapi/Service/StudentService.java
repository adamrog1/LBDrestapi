package com.example.lbdrestapi.Service;

import com.example.lbdrestapi.Model.Student;
import com.example.lbdrestapi.Model.Subjects;
import com.example.lbdrestapi.Model.Teacher;
import lombok.Data;
import org.apache.catalina.valves.StuckThreadDetectionValve;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Data
public class StudentService {

    private List<Student> students;
    private List<Subjects> subjects;
    private List<Subjects> subjects1;


    public StudentService(){
        subjects=new ArrayList<>();
        subjects1=new ArrayList<>();
        subjects.add(Subjects.ALGEBRA);
        subjects1.add(Subjects.BIOLOGY);
        subjects1.add(Subjects.LAW);
        Student student1=new Student(1L,"Adam","Rogalski",22, subjects1);
        Student student2=new Student(2L, "qeq","rgw",23,subjects);
        Student student3=new Student(3L, "qeq","rgw",23, subjects1);
        Student student4=new Student(4L, "asd","rgw",23, subjects);
        Student student5=new Student(5L, "qeq","grrw",23, subjects);
        students=new ArrayList<>();
        Collections.addAll(students,student1,student2,student3,student4,student5);
    }

    public Student addStudent(Student student) {
        Student newstudent=new Student((long) (students.size() + 1),student.getName(),student.getSurname(),student.getAge(),student.getSubjectsList());
        return newstudent;
    }
    public List<Student> getAllStudents(){
        return students;
    }

    public Student editStudent(Long id, String newSurname, int newAge){
        students.get(Math.toIntExact(id-1)).setAge(newAge);
        students.get(Math.toIntExact(id-1)).setSurname(newSurname);
        return students.get(Math.toIntExact(id-1));
    }

    public void deleteStudent(Long id){
        students.remove(Math.toIntExact(id-1));
    }

    public Student getStudent(Long id){
        return students.get(Math.toIntExact(id-1));
    }
}
