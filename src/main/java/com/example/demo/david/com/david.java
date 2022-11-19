package com.example.demo.david.com;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping

public class david {

    @GetMapping("/Morningmessage")
    public String printmorningmessage(){
        return "Good Morning Sir.It is a chilly morning";
    }
}
