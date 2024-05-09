package com.example.coursemanagement;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = "com.example.coursemanagement")
public class CourseManagementApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(CourseManagementApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

}
