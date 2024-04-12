package com.example.coursemanagement.Controller;



import com.example.coursemanagement.Model.Professor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/Owner")
public class Owner {

    @PostMapping("/addProf")
    public Professor add(Professor prof){{
        return prof;
    }

    }

}
