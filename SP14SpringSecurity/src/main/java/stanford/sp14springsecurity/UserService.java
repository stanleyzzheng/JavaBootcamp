package stanford.sp14springsecurity;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;

interface UserService extends UserDetailsService  {
    public UserDetails loadUserByUsername(String userName);
    public void create(UserDTO userDTO);
    public User findUserByEmail(String email);
    public User findUserByName(String name);

}
