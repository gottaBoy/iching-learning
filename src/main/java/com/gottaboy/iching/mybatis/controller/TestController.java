package com.gottaboy.iching.mybatis.controller;

import com.gottaboy.iching.mybatis.annotation.IchingTag;
import com.gottaboy.iching.mybatis.annotation.IchingTags;
import com.gottaboy.iching.mybatis.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @IchingTag(value = "i1 love sting")
//    @IchingTag(value = "i2 love sting")
//    @IchingTag(value = "i3 love sting")
    @GetMapping(value = "/test")
    public String myTest() {
        return "test";
    }

    @IchingTag(value = "i1 love sting")
    @GetMapping(value = "/test1")
    public String myTest1(@RequestParam("name") String name) {
        return "test1";
    }

    @GetMapping(value = "/student")
    public String student() {
        Student student = new Student();
        student.setAge(20);
        student.setName("iching");
        student.getName();
        student.getAge();
        student.printThrowException();
        return "success";
    }
}
