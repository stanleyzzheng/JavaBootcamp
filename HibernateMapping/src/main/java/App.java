import model.Address;
import model.Cohort;
import model.Department;
import model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) {
//        manyToOne();
//        oneToMany();
//    oneToOne();
        manyToMany();

    }


public static void manyToMany(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

    Cohort class1 = new Cohort("Java Developer", "14 weeks");
    Cohort class2 = new Cohort("FullStack Developer", "7 weeks");
    Cohort class3 = new Cohort("Python Developer", "12 weeks");

    session.persist(class1);
    session.persist(class2);
    session.persist(class3);

    Set<Cohort> classSet1 = new HashSet<>();
    classSet1.add(class1);
    classSet1.add(class2);
    classSet1.add(class3);

    Set<Cohort> classSet2 = new HashSet<>();
    classSet2.add(class1);
    classSet2.add(class2);
    classSet2.add(class3);

    Set<Cohort> classSet3 = new HashSet<>();
    classSet3.add(class1);
    classSet3.add(class2);
    classSet3.add(class3);

    Teacher t1 = new Teacher("100", "Haseeb", classSet1);
    Teacher t2 = new Teacher("200", "jenny", classSet2);
    Teacher t3 = new Teacher("200", "Charlie", classSet3);
    session.persist(t1);
    session.persist(t2);
    session.persist(t3);

    t.commit();


}
    public static void manyToOne() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Department dept1 = new Department("IT");
        Department dept2 = new Department("HR");

        Teacher t1 = new Teacher("1000", "MHaseeb", dept1);
        Teacher t2 = new Teacher("2220", "Shahparan", dept1);
        Teacher t3 = new Teacher("3000", "James", dept1);
        Teacher t4 = new Teacher("40000", "Joseph", dept2);

        session.persist(dept1);
        session.persist(dept2);

        session.persist(t1);
        session.persist(t2);
        session.persist(t3);
        session.persist(t4);
        transaction.commit();
    }

    public static void oneToMany() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Teacher t1 = new Teacher("1000", "MHaseeb");
        Teacher t2 = new Teacher("2220", "Shahparan");
        Teacher t3 = new Teacher("3000", "James");
        Teacher t4 = new Teacher("40000", "Joseph");
        Teacher t5 = new Teacher("200", "Ali");

        ArrayList<Teacher> teacherArrayList = new ArrayList<>();
        teacherArrayList.add(t1);
        teacherArrayList.add(t2);
        teacherArrayList.add(t3);
        teacherArrayList.add(t4);
        teacherArrayList.add(t5);

        session.persist(t1);
        session.persist(t2);
        session.persist(t3);
        session.persist(t4);
        session.persist(t5);

        Department department = new Department();
        department.setDeptName("Development");
        department.setTeacherList(teacherArrayList);

        session.persist(department);
        t.commit();
    }

    public static void oneToOne(){
        System.out.println("Maven + Hibernate + SQL One to One Mapping Annotations");

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        Address a1 = new Address("27th street", "NYC", "NY", 11103);
        Address a2 = new Address("28th street", "Buffalo", "NY", 15803);

        Teacher t1 = new Teacher("1000", "MHaseeb");
        Teacher t2 = new Teacher("2220", "Shahparan");
        t1.setAddress(a1);
        t2.setAddress(a2);

        session.persist(a1);
        session.persist(t1);
        session.persist(a2);
        session.persist(t2);

        t.commit();
    }
}
