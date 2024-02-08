import java.util.Date;

class SalesRep {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String dateOfBirth;

    public SalesRep(String userId, String firstName, String lastName, String email, String phone, String dateOfBirth) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
    }
    public SalesRep(){}

    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
}