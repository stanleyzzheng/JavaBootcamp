import jakarta.persistence.TypedQuery;
import model.Department;
import model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class manyToOneInteractive {
    public static void main(String[] args) {
        manyToOneInteractive();
    }

    public static void manyToOneInteractive() {
        System.out.println("Welcome to ManyToOneInteractive!");
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
//        Transaction transaction = session.beginTransaction();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n0. Exit");
                System.out.println("1. Manage Departments");
                System.out.println("2. Manage Teachers");
                System.out.println("3. Assign Teacher to Department");
                System.out.println("4. List Teachers");
                System.out.println("5. List Department");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 0:
                        System.out.println("Exiting...");
                        return;
                    case 1:
                        manageDepartments(scanner, factory);
                        break;
                    case 2:
                        manageTeachers(scanner, factory);
                        break;
                    case 3:
                        assignTeacherToDepartment(scanner, session);
                        break;
                    case 4:
                        listTeachers(session);
                        break;
                    case 5:
                        listDepts(session);
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
            factory.close();

        }



    }

    private static void manageDepartments(Scanner scanner, SessionFactory factory) {
        // Placeholder for department management logic (add/delete/modify)
        Session session = factory.openSession();

        System.out.println("\n1. Add Departments");
        System.out.println("2. Delete Department");
        System.out.println("3. Modify Department");
        System.out.println("4. Go back to menu");

//        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Transaction transaction = session.beginTransaction();

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter the number of departments to Add: ");
                int numDep = scanner.nextInt();
                ArrayList<Department> depsArray = new ArrayList<>();
                for (int i = 0; i < numDep; i++) {
                    System.out.print("Enter Dept Name: ");
                    String depName = scanner.next();
                    Department dep = new Department(depName);
                    depsArray.add(dep);
                }
                for (int i = 0; i < depsArray.size(); i++) {
                    session.persist(depsArray.get(i));
                }
                transaction.commit();
//                factory.close();
//                session.close();
                break;
            case 2:
                System.out.println("Which department would you like to delete: ");

                listDepts(session);
                int deptId = scanner.nextInt();
                Department d = session.get(Department.class, deptId);
                for (Teacher teacher : d.getTeacherList()) {
//                    System.out.println(teacher);
                    teacher.setDepartment(null);
                    session.merge(teacher);
//                    System.out.println(teacher.getDepartment());
                }
                session.remove(d);

                transaction.commit();
                System.out.println("Department Deleted");

                break;
            case 3:
//                assignTeacherToDepartment(scanner, factory);
                System.out.println("Which department would you like to modify: ");

                listDepts(session);
                int deptId2 = scanner.nextInt();
                System.out.println("Give a new name for department:");
                String deptName = scanner.next();
                Department d2 = new Department();
                d2.setDeptId(deptId2);
                d2.setDeptName(deptName);
                session.merge(d2);
                session.getTransaction().commit();

                break;
            case 4:
                System.out.println("Go back");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }

    }

    private static void manageTeachers(Scanner scanner, SessionFactory factory) {
        // Placeholder for teacher management logic (add/delete/modify)
        Session session = factory.openSession();

        System.out.println("\n1. Add Teachers");
        System.out.println("2. Delete Teacher");
        System.out.println("3. Modify Teacher");
        System.out.println("4. Go back to menu");

        Transaction transaction = session.beginTransaction();

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Enter the number of Teachers to Add: ");
                int numTeach = scanner.nextInt();
                ArrayList<Teacher> teachArray = new ArrayList<>();
                for (int i = 0; i < numTeach; i++) {
                    System.out.print("Enter Teacher Name: ");
                    String teachName = scanner.next();
                    listDepts(session);

                    System.out.println("Enter Teacher department: ");
                    int deptId = scanner.nextInt();
                    Department dept = session.get(Department.class, deptId);
                    Teacher teacher = new Teacher(teachName, dept);
                    teachArray.add(teacher);
                }
                for (int i = 0; i < teachArray.size(); i++) {
                    session.persist(teachArray.get(i));
                }
                System.out.println("Added teachers");
                transaction.commit();

                break;
            case 2:
                System.out.println("Which Teacher would you like to delete: ");
//                TypedQuery<Object[]> query = session.createQuery("SELECT T.teacherId, teacherName FROM Teacher AS T",
//                        Object[].class);
//                List<Object[]> results = query.getResultList();
//                System.out.printf("%s %s%n", "Teacher Id", "Teacher Name");
//                for (Object[] a : results) {
//                    System.out.printf("%s. %s%n", a[0], a[1]);
//                }
                listTeachers(session);
                int teachId = scanner.nextInt();
                Teacher d = new Teacher();
                d.setTeacherId(teachId);
                session.remove(d);
                transaction.commit();
                System.out.printf("Teacher %s Deleted%n", teachId);

                break;
            case 3:
                System.out.println("Which Teacher would you like to modify: ");

                listTeachers(session);
                int teachId2 = scanner.nextInt();
                System.out.println("Give a new name for Teacher:");
                String teachName = scanner.next();
                Teacher t2 = new Teacher();
                t2.setTeacherId(teachId2);
                t2.setTeacherName(teachName);
                session.merge(t2);
                session.getTransaction().commit();

                break;
            case 4:
                System.out.println("Go back");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }

    private static void assignTeacherToDepartment(Scanner scanner, Session session) {
        // Placeholder for assigning teachers to departments
        Transaction transaction = session.beginTransaction();
        listTeachers(session);
        System.out.println("Which Teacher would you like to modify: ");

        int teachId = scanner.nextInt();
        listDepts(session);
        System.out.println("Which department would you like to assign to Teacher: ");

        int deptId = scanner.nextInt();

        Department d = session.get(Department.class, deptId);
        Teacher teacherUpdate = session.get(Teacher.class, teachId);
        teacherUpdate.setDepartment(d);
        session.merge(teacherUpdate);
        transaction.commit();

        System.out.println("Teacher modified");
    }

    private static void listDepts(Session session) {
        TypedQuery<Object[]> query = session.createQuery("SELECT D.deptId, D.deptName FROM Department AS D",
                Object[].class);
        List<Object[]> results = query.getResultList();
        System.out.printf("%s%s%n", "Department Id", "Department Name");
        for (Object[] a : results) {
            System.out.printf("%s. %s%n", a[0], a[1]);
        }
    }

    private static void listTeachers(Session session) {
        TypedQuery<Object[]> query2 = session.createQuery("SELECT T.teacherId, teacherName FROM Teacher AS T",
                Object[].class);
        List<Object[]> results2 = query2.getResultList();
        System.out.printf("%s %s%n", "Teacher Id", "Teacher Name");

        for (Object[] a : results2) {
            System.out.printf("%5s. %s%n", a[0], a[1]);
        }
    }


}
