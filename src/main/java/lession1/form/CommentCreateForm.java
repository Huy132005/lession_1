package lession1.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CommentCreateForm {
    @NotBlank(message = "k dc de trong")
    @Length(max = 200, message = "toi da 200 ky tu")
    private String Content;

    @NotBlank(message = "k dc de trong")
    private Long postId;}
