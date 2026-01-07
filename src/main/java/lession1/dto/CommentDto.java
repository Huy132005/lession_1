package lession1.dto;


import lession1.entity.Post;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
@Getter
@Setter
public class CommentDto {
    private Long id;
    private String Content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long postId;
}
