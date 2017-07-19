//package com.example.demoa.hello;
//
///**
// * Created by yanyanho on 2017/7/13.
// */
//
//import org.hibernate.annotations.GenericGenerator;
//
//import javax.persistence.*;
//
///**
// * 部门表实体类
// */
//@Entity
//@Table(name = "dept", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
//public class Dept {
//
//    //部门编号 主键
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(generator = "uuid2")
//    @GenericGenerator(name = "uuid2", strategy = "uuid2")
//    private String id;
//
//    //部门编码
//    @Column(name = "code")
//    private String code;
//
//    //部门名称
//    @Column(name = "name")
//    private String name;
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}
