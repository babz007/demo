package com.example.demo.student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository) {
        return args -> {
            Student babs = new Student(
                    "Babs",
                    "ainababs0@gmail.com",
                    LocalDate.of(1998, Month.FEBRUARY,21)

            );

            Student yemi = new Student(
                    "Yemi",
                    "ainayemi@gmail.com",
                    LocalDate.of(2005, Month.JUNE,11)
                                );


            repository.saveAll(
                    List.of(babs, yemi)
            );
        };

    }
}
