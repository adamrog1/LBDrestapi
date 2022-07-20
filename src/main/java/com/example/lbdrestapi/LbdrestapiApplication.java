package com.example.lbdrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class LbdrestapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LbdrestapiApplication.class, args);
    }

}
