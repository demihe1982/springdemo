package com.example.demo.controller.v1;

import com.example.demo.vo.Demo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    @RequestMapping("test")
    public ResponseEntity<Demo> testReturnObj(){
        Demo demo = new Demo();
        demo.setAge(1);
        demo.setName("demo");
        return new ResponseEntity<>(demo, HttpStatus.OK);
    }
}
