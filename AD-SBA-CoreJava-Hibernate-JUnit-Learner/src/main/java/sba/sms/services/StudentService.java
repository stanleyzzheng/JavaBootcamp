package sba.sms.services;

import lombok.extern.java.Log;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import sba.sms.dao.StudentI;
import sba.sms.models.Course;
import sba.sms.models.Student;
import sba.sms.utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * StudentService is a concrete class. This class implements the
 * StudentI interface, overrides all abstract service methods and
 * provides implementation for each method. Lombok @Log used to
 * generate a logger file.
 */

public class StudentService implements StudentI {
    private SessionFactory factory;
    private Session session;

    public StudentService() {
        this.factory = HibernateUtil.getSessionFactory();
        openSession();

    }

    private void openSession() {
        if (session == null || !session.isOpen()) {
            session = factory.openSession();
        }
    }

    public void closeSession() {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = null;
        try {
            String hql = "FROM Student";
            Query<Student> query = session.createQuery(hql, Student.class);
            students = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        finally {
//            closeSession();
//        }
        return students;
    }

    @Override
    public void createStudent(Student student) {
        try {
            Transaction transaction = session.beginTransaction();
            session.persist(student);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        finally {
//            closeSession();
//        }
    }

    @Override
    public Student getStudentByEmail(String email) {
        Student student = null;
        try {
            String hql = "FROM Student WHERE email=:email";
            Query<Student> query = session.createQuery(hql, Student.class);
            query.setParameter("email", email);
            student = query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        finally {
//            closeSession();
//        }
        return student;
    }

    @Override
    public boolean validateStudent(String email, String password) {
        Student student = null;
        try{
            String hql = "FROM Student WHERE email=:email AND password=:password";
            Query<Student> query = session.createQuery(hql,Student.class);
            query.setParameter("email",email);
            query.setParameter("password",password);
            student = query.uniqueResult();
        }catch(Exception e){
            e.printStackTrace();
        }
//        finally {
//            closeSession();
//        }
        return student != null;
    }

    @Override
    public void registerStudentToCourse(String email, int courseId) {
<<<<<<< HEAD
//        try{
//            openSession();
//
//        }
=======
        try{
            Transaction tx = session.beginTransaction();
            Student s = session.get(Student.class, email);
            Set<Course> c = s.getCourses();
            Course newCourse = session.get(Course.class,courseId);
            c.add(newCourse);
            s.setCourses(c);
            session.merge(s);

            tx.commit();
            
        } catch(Exception e){
            e.printStackTrace();
        }
>>>>>>> f693a06c6eef6e51ff3d7c50d6a87143db66aec3

    }

    @Override
    public List<Course> getStudentCourses(String email) {
        List<Course> studentCourses = null;

        try{

            String hql = "SELECT c FROM Course c JOIN c.students s WHERE s.email=:email";
            Query<Course> query = session.createQuery(hql,Course.class);
            query.setParameter("email",email);
            studentCourses = query.getResultList();

        }catch(Exception e){
            e.printStackTrace();
        }
//        finally {
//            closeSession();
//        }
        return studentCourses;

    }
}
