package com.cerlite.playground.bidirecta;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping
    public String getIndex() {
        return "hello";
    }

}
