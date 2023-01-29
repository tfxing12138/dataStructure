package com.tfxing.dataStructure.service.impl;

import com.tfxing.dataStructure.dao.PersonMapper;
import com.tfxing.dataStructure.entity.Person;
import com.tfxing.dataStructure.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :tanfuxing
 * @date :2023/1/29
 * @description :
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Resource
    private PersonMapper personMapper;

    @Override
    public List<Person> list() {
        return personMapper.list();
    }
}
