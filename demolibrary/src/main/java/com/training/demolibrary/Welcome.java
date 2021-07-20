package com.training.demolibrary;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {

    @GetMapping("/greet")
    public String getMessage(){
        return "welcome to Library Management";
    }
}
