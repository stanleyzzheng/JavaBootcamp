package stanford.capstone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stanford.capstone.model.Department;
import stanford.capstone.repository.DepartmentRepository;
import stanford.capstone.service.DepartmentService;

import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department findDepartmentById(Long id) {
        Optional<Department> departmentOptional = departmentRepository.findById(id);
        return departmentOptional.orElse(null);
    }
}
