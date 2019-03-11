package com.jcex.test.service;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class User implements Serializable{
    @Id
    @GeneratedValue
    private Long order_id;
    private String customer_reference_number;

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public String getCustomer_reference_number() {
        return customer_reference_number;
    }

    public void setCustomer_reference_number(String customer_reference_number) {
        this.customer_reference_number = customer_reference_number;
    }


//    private Integer age;
//    private String address;

    public User(){

    }


//    public User(String name, Integer age, String address) {
//        this.name = name;
//        this.age = age;
//        this.address = address;
//    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                ", address='" + address + '\'' +
//                '}';
//    }
}
