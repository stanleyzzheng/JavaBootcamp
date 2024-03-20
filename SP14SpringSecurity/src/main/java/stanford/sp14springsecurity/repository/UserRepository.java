package stanford.sp14springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stanford.sp14springsecurity.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
 public User findUserByEmail(String email);
 public User findUserByUserName(String name);
}
