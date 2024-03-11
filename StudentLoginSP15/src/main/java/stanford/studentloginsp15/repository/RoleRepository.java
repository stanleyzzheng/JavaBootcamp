package stanford.studentloginsp15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stanford.studentloginsp15.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
