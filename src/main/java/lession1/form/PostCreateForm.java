package lession1.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class PostCreateForm {

    @NotBlank(message = "k dc de trong")
    @Length(max = 50, message = "toi da 50 ky tu")
    private String title;
    @NotBlank(message = "k dc de trong")
    @Length(max = 150, message = "toi da 150 ky tu")
    private String content;
}
