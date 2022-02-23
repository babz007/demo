package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
//blueprint of thr class, abstract method
public interface StudentRepository
        extends JpaRepository <Student, Long>{


    //custom function finds a user by email
    //Select * FROM student WHERE email = ?
   // Optional<Student> findStudentByEmail(String email);
}
