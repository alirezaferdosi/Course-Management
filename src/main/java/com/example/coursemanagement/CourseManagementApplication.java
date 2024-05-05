package com.example.coursemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.example.coursemanagement")
public class CourseManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseManagementApplication.class, args);
    }

}
