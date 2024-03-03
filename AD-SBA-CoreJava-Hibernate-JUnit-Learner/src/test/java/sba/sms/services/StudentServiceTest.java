package sba.sms.services;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sba.sms.models.Course;
import sba.sms.models.Student;
import sba.sms.utils.CommandLine;
import sba.sms.utils.HibernateUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.assertj.core.api.Assertions.*;


class StudentServiceTest {
    static final StudentService studentService = new StudentService();

    static final CourseService courseService = new CourseService();


//    @AfterEach
//    public void tearDown() {
//        // Close or reset your application context after each test
//        studentService.closeSession();
//        courseService.closeSession();
//    }

    @Test
    void shouldCreateNewStudent() {
        Student student = new Student("stanley@gmail.com", "stanley", "password");
        studentService.createStudent(student);
        assertThat(studentService.getStudentByEmail(student.getEmail())).isEqualTo(student);

    }

    @Test
    void shouldCreateNewCourse() {
        Course course = new Course("Algebra", "Stanley");
        courseService.createCourse(course);
        assertThat(courseService.getCourseById(1)).isEqualTo(course);
    }

//    @Test
//    void shouldRegisterStudentToCourse() {
//        Student student = new Student("stanley@gmail.com", "stanley", "password");
//        studentService.createStudent(student);
//        Course course = new Course("Math", "Stanley");
//        courseService.createCourse(course);
////
////        System.out.println(studentService.getAllStudents());
//        System.out.println(courseService.getAllCourses());
//        studentService.registerStudentToCourse(student.getEmail(), course.getId());
//        List<Course> userCourses = studentService.getStudentCourses(student.getEmail());
//
//        System.out.println(userCourses);
//        assertThat(userCourses.size()).isEqualTo(1);
//
//    }


}