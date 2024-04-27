package com.example.student.dtos.requests;

/**
 * Copyright (c) 2024 Wasif
 */

/**
 * This class is a dto class of student registration
 * It defines the details of different students.
 *
 * @author wasif
 * @version 1.0
 * @since 27/04/24
 */
public class StudentRegistrationDto {
    private String phone;

    //constructor
    public StudentRegistrationDto() {
    }

    public StudentRegistrationDto(String phone) {
        this.phone = phone;
    }

    //getter & setter

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
