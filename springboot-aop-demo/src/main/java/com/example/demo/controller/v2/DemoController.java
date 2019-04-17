package com.example.demo.controller.v2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("demoControllerv2")
@RequestMapping("/demo/v2/")
public class DemoController {


    @RequestMapping("hello")
    public String sayHello(@RequestParam String name){
        return "Hello "+name;
    }
}
