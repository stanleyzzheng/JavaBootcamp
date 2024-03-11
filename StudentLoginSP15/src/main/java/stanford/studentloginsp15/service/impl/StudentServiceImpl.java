package stanford.studentloginsp15.service.impl;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import stanford.studentloginsp15.dto.StudentDTO;
import stanford.studentloginsp15.model.Role;
import stanford.studentloginsp15.model.Student;
import stanford.studentloginsp15.repository.RoleRepository;
import stanford.studentloginsp15.repository.StudentRepository;
import stanford.studentloginsp15.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public StudentServiceImpl(StudentRepository studentRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveStudent(StudentDTO studentDTO){
        Student student = new Student();
        student.setName(studentDTO.getFirstName() + " " + studentDTO.getLastName());
        student.setEmail(studentDTO.getEmail());
        student.setPassword(passwordEncoder.encode(studentDTO.getPassword()));
        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        student.setRoles(Arrays.asList(role));
        studentRepository.save(student);
    }

    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
    @Override
    public Student findStudentByEmail(String email){
        return studentRepository.findByEmail(email);
    }

    @Override
    public List<StudentDTO> findAllStudents(){
        List<Student> students = studentRepository.findAll();
        return students.stream().map((student -> mapToStudentDto(student))).collect(Collectors.toList());
    }

    private StudentDTO mapToStudentDto(Student student){
        StudentDTO studentDTO = new StudentDTO();
        String[] str = student.getName().split(" ");
        studentDTO.setFirstName(str[0]);
        studentDTO.setLastName(str[1]);
        studentDTO.setEmail(student.getEmail());
        return studentDTO;
    }
}

