package sba.sms.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Course is a POJO, configured as a persistent class that represents (or maps to) a table
 * name 'course' in the database. A Course object contains fields that represent course
 * information and a mapping of 'courses' that indicate an inverse or referencing side
 * of the relationship. Implement Lombok annotations to eliminate boilerplate code.
 */

//@NoArgsConstructor
//@AllArgsConstructor
//@RequiredArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table
public class Course {
    public Course(String name, String instructor) {
        this.name = name;
        this.instructor = instructor;
    }

    public Course() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String instructor;
    @ManyToMany(mappedBy = "courses", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Student> students;

}
