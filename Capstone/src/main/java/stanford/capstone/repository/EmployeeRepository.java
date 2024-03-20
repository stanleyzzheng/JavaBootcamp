package stanford.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stanford.capstone.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public Employee findEmployeeByEmail(String email);

}
