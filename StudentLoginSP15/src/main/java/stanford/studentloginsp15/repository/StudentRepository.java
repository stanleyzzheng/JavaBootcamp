package stanford.studentloginsp15.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import stanford.studentloginsp15.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{
    Student findByEmail(String email);
}
