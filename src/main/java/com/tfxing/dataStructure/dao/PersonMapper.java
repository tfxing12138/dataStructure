package com.tfxing.dataStructure.dao;

import com.tfxing.dataStructure.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author :tanfuxing
 * @date :2023/1/29
 * @description :
 */
@Mapper
@Repository
public interface PersonMapper {
    List<Person> list();
}
