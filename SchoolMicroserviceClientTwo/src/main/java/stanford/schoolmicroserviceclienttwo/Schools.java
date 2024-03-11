package stanford.schoolmicroserviceclienttwo;
import java.util.UUID;
public class Schools {
    private UUID id;
    private String Schoolname;
    private String address;

    public Schools(UUID id, String schoolname, String address) {
        this.id = id;
        this.Schoolname = schoolname;
        this.address = address;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public String getSchoolname() {
        return Schoolname;
    }

    public void setSchoolname(String schoolname) {
        Schoolname = schoolname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "Schools{" +
                "id=" + id +
                ", Schoolname='" + Schoolname + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}