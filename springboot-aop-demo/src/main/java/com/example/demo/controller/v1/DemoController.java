package com.example.demo.controller.v1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("demoControllerv1")
@RequestMapping("/demo/v1/")
public class DemoController {


    @RequestMapping("hello")
    public String sayHello(@RequestParam String name){
        return "Hello "+name;
    }
}
