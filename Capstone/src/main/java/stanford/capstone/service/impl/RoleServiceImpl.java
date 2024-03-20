package stanford.capstone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stanford.capstone.model.Role;
import stanford.capstone.repository.RoleRepository;
import stanford.capstone.service.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role findRoleByRoleName(String name) {
        return roleRepository.findRoleByName(name);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public List<Role> getRolesByEmployee(long id) {
        return roleRepository.findRoleByEmployee(id);
    }
}
