package stanford.studentloginsp15.service;

import stanford.studentloginsp15.dto.StudentDTO;
import stanford.studentloginsp15.model.Student;

import java.util.List;

public interface StudentService {
    void saveStudent(StudentDTO studentDTO);
    Student findStudentByEmail(String email);
    List<StudentDTO> findAllStudents();
}
