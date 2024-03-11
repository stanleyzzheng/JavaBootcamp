package stanford.sp14springsecurity;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@FieldMatch.List({
        @FieldMatch(first="password", second="matchingPassword",message="The password fields must match")
})
class UserDTO {
    @NotEmpty
    private String userName;
    @Pattern(regexp = "[A-Za-z]+$", message="Only alphabetic allowed")
    private String firstName;
    @Pattern(regexp = "[A-Za-z]+$", message="Only alphabetic allowed")
    private String lastName;
    @Column(unique = true)
    @Email
    private String email;
    private String phone;

    @Pattern(regexp = "[0-9]{5}$", message="Zip code wrong format")
    private String zip;

    @NotEmpty(message="Required")
    private String password;

    @NotEmpty(message="Required")
    private String matchingPassword;

    public UserDTO(String userName, String firstName, String lastName, String email, String phone, String zip, String password, String matchingPassword) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.zip = zip;
        this.password = password;
        this.matchingPassword = matchingPassword;
    }
}
