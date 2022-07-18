package com.example.lbdrestapi.Model;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;


@Data
@Component
public class Student {

    private Long id;
    private String name;
    private String surname;
    private int age;
    private List<Subjects> subjectsList;

    public Student(Long id, String name, String surname, int age, List<Subjects> list) {
        this.subjectsList=list;
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Student() {}
}
