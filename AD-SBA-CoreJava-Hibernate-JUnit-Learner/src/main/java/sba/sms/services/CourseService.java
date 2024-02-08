package sba.sms.services;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sba.sms.dao.CourseI;
import sba.sms.models.Course;
import sba.sms.utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * CourseService is a concrete class. This class implements the
 * CourseI interface, overrides all abstract service methods and
 * provides implementation for each method.
 */
public class CourseService implements CourseI {
    private SessionFactory factory;
    private Session session;

    public CourseService() {
        this.factory = HibernateUtil.getSessionFactory();

    }

    private void openSession() {
        if (session == null || !session.isOpen()) {
            session = factory.openSession();
        }
    }

    private void closeSession() {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    @Override
    public void createCourse(Course course) {
        try {
            openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(course);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            closeSession();
        }
    }

    @Override
    public Course getCourseById(int courseId) {
        Course course = null;
        try{
            openSession();
            String hql = "FROM Course WHERE id = :courseId";
            Query<Course> query = session.createQuery(hql, Course.class);
            course = query.uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeSession();
        }

        return course;
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses=null;
        try{
            openSession();
            String hql = "FROM Course";
            Query<Course> query = session.createQuery(hql, Course.class);
            courses = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeSession();
        }

        return courses;
    }
}
