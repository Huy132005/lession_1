package lession1.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lession1.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class UserCreateForm {
    @NotBlank
    @Length(max = 50)
    private String username;
    @Email
    @NotBlank
    @Length(max = 50)
    private String email;
    @NotBlank
    @Length(max = 32, min = 8)
    private String password;
    @NotBlank
    @Pattern(regexp = "ADMIN|EMPLOYEE|MANAGER")
    private String role;

    public void setPassword(@NotBlank @Length(max = 32, min = 8) String password) {
        this.password = password;
    }
}
