package com.example.lbdrestapi.Service;

import com.example.lbdrestapi.Model.Student;
import com.example.lbdrestapi.Model.Subjects;
import com.example.lbdrestapi.Model.Teacher;
import com.sun.security.auth.callback.TextCallbackHandler;
import org.springframework.stereotype.Service;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TeacherService {

    private List<Teacher> teacherList;
    private StudentService studentService;

    public TeacherService(StudentService studentService){
        this.studentService=studentService;
        teacherList=new ArrayList<>();
        Teacher teacher1=new Teacher(1L,"Hanna","Beck", Subjects.ALGEBRA);
        Teacher teacher2=new Teacher(2L,"Anna","Hood",Subjects.BIOLOGY);
        Teacher teacher3=new Teacher(3L, "Wanda","White",Subjects.LAW);
        Collections.addAll(teacherList,teacher1,teacher2,teacher3);
    }

    public List<Teacher> getAllTeachers(){
        return teacherList;
    }

    public Teacher addTeacher(Teacher teacher){
        Teacher newTeacher=new Teacher((long) (teacherList.size() + 1),teacher.getName(),teacher.getSurname(),teacher.getSubject());
        teacherList.add(newTeacher);
        return newTeacher;
    }

    public void deleteTeacher(Long id){
        teacherList.remove(Math.toIntExact(id-1));
    }

    public Teacher getTeacher(Long id){
        return teacherList.get(Math.toIntExact(id-1));
    }

    public List<Student> getTeacherClass(Long id){
        List<Student> studentList=new ArrayList<>();
        Subjects subject= teacherList.get(Math.toIntExact(id-1)).getSubject();
        for(Student s:studentService.getStudents()){
            if(s.getSubjectsList().contains(subject)) studentList.add(s);
        }
        return studentList;
    }

    public void deleteStudentFromClassByTeacherId(Long teacherID, Long studentID){
        try {
            Subjects subject = teacherList.get(Math.toIntExact(teacherID - 1)).getSubject();
            if (studentService.getStudent(studentID) != null)
                studentService.getStudent(studentID).getSubjectsList().remove(subject);
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
