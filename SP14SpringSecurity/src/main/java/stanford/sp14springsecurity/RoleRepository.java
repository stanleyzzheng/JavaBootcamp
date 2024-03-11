package stanford.sp14springsecurity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

interface RoleRepository extends JpaRepository<Role,Long> {
    public Role findRoleByName(String role);
    @Query(value="select * from role where role.id=(select role_id from users_roles where user_id = :id)", nativeQuery=true)
    public List<Role> findRoleByUser(@Param("id") long id);
}
