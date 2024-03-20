package stanford.sp14springsecurity.model;
import lombok.*;
import jakarta.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    public Role(String name){
        this.name = name;
    }
}
