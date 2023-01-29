package com.tfxing.dataStructure.controller;

import com.tfxing.dataStructure.entity.Person;
import com.tfxing.dataStructure.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :tanfuxing
 * @date :2023/1/29
 * @description :
 */
@RequestMapping("/person")
@RestController
public class PersonController {
    
    @Resource
    private PersonService personService;
    
    @GetMapping("/list")
    public List<Person> list() {
        return personService.list();
    }
}
