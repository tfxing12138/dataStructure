package com.tfxing.dataStructure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :tanfuxing
 * @date :2023/1/29
 * @description :
 */
@RequestMapping("/helloWorld")
@RestController
public class TestController {
    
    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "helloWorld";
    }
}
