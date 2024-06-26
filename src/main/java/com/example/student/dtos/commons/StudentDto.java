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

    /**
     * It represents the unique id of every record.
     */
    private Long id;
    /**
     * It represents the name of the students
     */
    private String name;
    /**
     * It represents the phone number of the students
     */
    private Long phone;
    /**
     * It represents the email of the students
     */
    private String email;

    //constructor
    public StudentDto() {
    }

    public StudentDto(Long id, String name, Long phone, String email) {
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

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
