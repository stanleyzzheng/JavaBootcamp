package sba.sms.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;


/**
 * Student is a POJO, configured as a persistent class that represents (or maps to) a table
 * name 'student' in the database. A Student object contains fields that represent student
 * login credentials and a join table containing a registered student's email and course(s)
 * data. The Student class can be viewed as the owner of the bi-directional relationship.
 * Implement Lombok annotations to eliminate boilerplate code.
 */

//@NoArgsConstructor
//@AllArgsConstructor
//@RequiredArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "student")
public class Student {
    @Id
    private  String email;
    private  String name;
    private  String password;

    public Student() {
    }

    public Student(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Course> courses;


}



