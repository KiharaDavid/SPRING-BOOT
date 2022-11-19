package com.example.demo.david;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apis")
public class Helloword {


    @GetMapping("/greetings")
    public String printHelloWorld(){
        return "Hello World";
    }


    @GetMapping("/salute")
    public String printSalute(){
        return "Hello Sirs";
    }

}
