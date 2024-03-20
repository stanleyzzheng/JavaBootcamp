package stanford.sp14springsecurity.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import stanford.sp14springsecurity.dto.UserDTO;
import stanford.sp14springsecurity.model.User;

public interface UserService extends UserDetailsService  {
    public UserDetails loadUserByUsername(String userName);
    public void create(UserDTO userDTO);
    public User findUserByEmail(String email);
    public User findUserByName(String name);

}
