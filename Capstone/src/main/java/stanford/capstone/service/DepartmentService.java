package stanford.capstone.service;

import stanford.capstone.model.Department;

import java.util.List;

public interface DepartmentService {
     Department findDepartmentById(Long id);
     List<Department> findAllDepartments();

}
