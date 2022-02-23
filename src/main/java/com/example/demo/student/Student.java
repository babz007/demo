package com.example.demo.student;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

@Entity
@Table
public class Student {

    //annotations here, maps the student to a table

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )


    private Long id;
    private String name;
    private String email;
    private LocalDate dob;


    @Transient // no need for the column to exist in the db
    private Integer age;
    private Integer DaystillBirthday;
    private Integer Nodays;



    public Student(Long id,
                   String name,
                   String email,
                   LocalDate dob
                   ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;

    }

    public Student(String name,
                   String email,
                   LocalDate dob
               ) {
        this.name = name;
        this.email = email;
        this.dob = dob;

    }

    public Student() {

    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    //Period between start and end
    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
    public void setAge(Integer age) {
        this.age = age;
    }



    public Integer getDaystillBirthday() {

        LocalDate today = LocalDate.now();
        LocalDate birthday = dob;

        LocalDate nextBDay = birthday.withYear(today.getYear());

        // If your birthday has occurred this year already, add 1 to the year.
        if (nextBDay.isEqual(today)) {
            System.out.println("HAPPY BIRTHDAY TO YOU !!");
        }

        else if (nextBDay.isBefore(today)) {
            nextBDay = nextBDay.plusYears(1);
        }

        Period p = Period.between(today, nextBDay);
        long p2 = ChronoUnit.DAYS.between(today, nextBDay);

        return Math.toIntExact(p2);
//
//        System.out.println("There are " + p.getMonths() + " months, and " +
//                p.getDays() + " days until your next birthday. (" +
//                p2 + " total)");





//        LocalDate dateAfter = LocalDate.now();
//        LocalDate dateBefore = dob;
//
//        long daysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
//        long monthsBetween = ChronoUnit.MONTHS.between(dateBefore, dateAfter);
//        long yearsBetween = ChronoUnit.YEARS.between(dateBefore, dateAfter);
//
//        return Math.toIntExact(monthsBetween);


        // return Period.between(this.dob, LocalDate.now()).getMonths();
    }

    public void setDaystillBirthday(Integer DaystillBirthday) {this.DaystillBirthday = DaystillBirthday;}


//    public Integer getNodays() {
//        return Period.between(this.dob, LocalDate.now()).getDays();}
//
//    public void setNodays(Integer Nodays) {this.Nodays = Nodays;}







    @Override // This child class method is over-writing its base class method and concatenates the result)
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                ",Months" + DaystillBirthday +
                ",Days" + Nodays +
                ",yyy" + Nodays +
                '}';
    }



}
