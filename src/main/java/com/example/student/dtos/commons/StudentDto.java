package com.example.student.dtos.commons;

/**
 * Copyright (c) 2024 Wasif
 */


/**
 * This class is a dto class with 4 member variables.
 * It defines the details of different students.
 *
 * @author wasif
 * @version 1.0
 * @since 27/04/24
 */
public class StudentDto {
    private Long id;
    private String name;
    private String phone;
    private String email;

    //constructor
    public StudentDto() {
    }

    public StudentDto(Long id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    //getter & setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
