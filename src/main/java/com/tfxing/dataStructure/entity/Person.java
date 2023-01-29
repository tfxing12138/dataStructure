package com.tfxing.dataStructure.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author :tanfuxing
 * @date :2023/1/29
 * @description : 人员类
 */
@Data
public class Person {
    
    private Long id;
    
    private String personName;
    
    private Integer age;
    
    private Integer sex;
    
    private String idCard;
    
    private String phoneNumber;
    
    private Integer personStatus;
    
    private Integer isDel;
    
    private Long leaderId;
    
    private Date createTime;
    
    private Date updateTime;
}
