package model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
public class Teacher implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherId;
    private String teacherName;
    @ManyToOne
    @JoinColumn(name = "department_Id")
    private Department department;


    public Teacher() {
    }


    public Teacher(String teacherName, Department department) {
        this.teacherName = teacherName;
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getTeacherId(){
        return teacherId;
    }
    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName; }

    @Override
    public String toString() {
        return "Teacher{" + "teacherId=" + teacherId + ", teacherName='" + teacherName + '\'' + ", department=" + department + '}';
    }
}
