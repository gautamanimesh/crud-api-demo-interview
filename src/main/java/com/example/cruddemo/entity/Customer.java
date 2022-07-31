package com.example.cruddemo.entity;

import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document
public class Customer {
    @Field
    String id;
    @Field
    String name;
    @Field
    int age;

    public Customer() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Customer(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
