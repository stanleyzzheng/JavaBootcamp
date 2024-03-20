package stanford.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import stanford.capstone.model.Role;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    public Role findRoleByName(String role);

    @Query(value="select * from role where role.id=(select role_id from employees_roles where employee_id=:id)", nativeQuery = true)
    public List<Role> findRoleByEmployee(@Param("id") long id);
}
