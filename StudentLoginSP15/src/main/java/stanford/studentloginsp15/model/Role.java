package stanford.studentloginsp15.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@Table(name ="roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false,unique = true)
    String name;
    @ManyToMany(mappedBy = "roles")
    List<Student> students = new ArrayList<>();

    public Role(Long id, String name, List<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }
}
