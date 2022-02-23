package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service // communication with @autowired annotation, borrowing declared class
public class StudentService {

    private final StudentRepository studentRepository;

    //constructor parameter
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents() {
        return studentRepository.findAll();

    }

    public void addNewStudent(Student student) {
        System.out.println(student);
    }

    public void updateStudent(Long studentId, String name, String email) {
    }

  /*  public void studentBirthday(long studentId, String name, LocalDate dob){
        Student student = studentRepository.findById(studentId)
                if ()


    } */

    //public void updateStudent(Long studentId, String name, String email) {

   /* @Transactional
    public void updateStudent(long studentId,
                              String name,
                              String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with Id " + studentId + "does not exist")

        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }


        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(student.getEmail(), email)) {
        Optional<Student> studentOptional = studentRepository
                .findStudentByEmail(email);
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        student.setEmail(email);


    }*/
}

