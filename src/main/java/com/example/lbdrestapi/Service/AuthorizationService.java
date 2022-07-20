package com.example.lbdrestapi.Service;

import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import java.io.IOException;

@Service
public class AuthorizationService {

    public boolean isAuthorized(String uri, String role) throws ServletException, IOException {

        if(uri.startsWith("/teachers") && role.equals("TEACHER_ROLE")){
            System.out.println("FALSE2");
            return true;
        }
        if (uri.startsWith("/students") && (role.equals("TEACHER_ROLE") || role.equals("STUDENT_ROLE"))) {
            System.out.println("FALSE1");
            return true;
        }

        return false;
    }
}
