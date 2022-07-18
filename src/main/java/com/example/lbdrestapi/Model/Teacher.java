package com.example.lbdrestapi.Model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Teacher {

    private Long id;
    private String name;
    private String surname;
    private Subjects subject;

    public Teacher(Long id, String name, String surname, Subjects subject) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.subject = subject;
    }

    public Teacher(){}
}
