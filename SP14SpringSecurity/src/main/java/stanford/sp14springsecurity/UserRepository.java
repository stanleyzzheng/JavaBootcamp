package stanford.sp14springsecurity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UserRepository extends JpaRepository<User,Long> {
 public User findUserByEmail(String email);
 public User findUserByUserName(String name);
}
