package com.example.student.repositories;

/**
 * Copyright (c) 2024 Wasif
 */

import com.example.student.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * This class is a repository interface which provides crud operation for {@link Student}
 *
 * @author Wasif
 * @version 1.0
 * @since 27/04/2024
 */

public interface StudentRepository extends JpaRepository<Student, Long> {
    /**
     * Find {@link Student} entity by phone number.
     *
     * @param phone - phone number to find entity. Must not be null.
     * @return Optional
     */
    Optional<Student> findByPhone(Long phone);

}
