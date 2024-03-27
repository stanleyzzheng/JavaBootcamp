package stanford.capstone.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import stanford.capstone.model.Role;
import stanford.capstone.repository.RoleRepository;

import java.util.Optional;

@Controller
@RequestMapping("/roles")
public class RoleController {
    private final RoleRepository roleRepository;

    private RoleController(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    @GetMapping("/{id}")
    private ResponseEntity<Role> findById(@PathVariable Long id){
        Optional<Role> roleOptional = roleRepository.findById(id);
        if(roleOptional.isPresent()){
            return ResponseEntity.ok(roleOptional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
