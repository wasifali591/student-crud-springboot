package com.example.student.dtos.requests;

/**
 * Copyright (c) 2024 Wasif
 */

/**
 * This class is a dto class of student registration
 *
 * @author wasif
 * @version 1.0
 * @since 27/04/24
 */
public class StudentRegistrationDto {
    /**
     * It represents the phone number of the student
     */
    private Long phone;

    //constructor
    public StudentRegistrationDto() {
    }

    public StudentRegistrationDto(Long phone) {
        this.phone = phone;
    }

    //getter & setter
    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
