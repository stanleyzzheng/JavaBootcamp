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
//@Setter
//@Getter
//@ToString
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(email, student.email) && Objects.equals(name, student.name) && Objects.equals(password, student.password) && Objects.equals(courses, student.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, password, courses);
    }

    @Override
    public String toString() {
        return "Student{" + "email='" + email + '\'' + ", name='" + name + '\'' + ", password='" + password + '\'' + ", courses=" + courses + '}';
    }
}



