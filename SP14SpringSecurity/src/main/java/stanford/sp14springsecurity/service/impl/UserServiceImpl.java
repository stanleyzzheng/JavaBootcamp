package stanford.sp14springsecurity.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stanford.sp14springsecurity.dto.UserDTO;
import stanford.sp14springsecurity.UserPrincipal;
import stanford.sp14springsecurity.model.Role;
import stanford.sp14springsecurity.model.User;
import stanford.sp14springsecurity.repository.UserRepository;
import stanford.sp14springsecurity.service.RoleService;
import stanford.sp14springsecurity.service.UserService;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(userName);
        log.debug(userName);
        if (user == null) {
            log.warn("Invalid username or password {}", userName);
            throw new UsernameNotFoundException("Invalid username or password.");

        }
        return new UserPrincipal(user, roleService.getRolesByUser(user.getId()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void create(UserDTO userDTO){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        User user = modelMapper.map(userDTO, User.class);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList(roleService.findRoleByRoleName("ROLE_USER")));

        userRepository.save(user);
    }

    public User findUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    public User findUserByName(String name){
        return userRepository.findUserByUserName(name);
    }
}
