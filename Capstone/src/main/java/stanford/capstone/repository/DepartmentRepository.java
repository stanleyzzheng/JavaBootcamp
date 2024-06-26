package stanford.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stanford.capstone.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
