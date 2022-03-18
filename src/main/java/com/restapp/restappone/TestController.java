package com.restapp.restappone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
public class TestController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/student")
    public Student getStudent() {
        return new Student(1, "Venkatesh Prasad");
    }

    @GetMapping(value = "/getstudentstring")
    private String getStudentString()
    {
        String uri = "http://localhost:8080/student";
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }

    @GetMapping(value = "/getstudent")
    private Student getStudentObject()
    {
        String uri = "http://localhost:8080/student";
        Student result = restTemplate.getForObject(uri, Student.class);
        return result;
    }
}