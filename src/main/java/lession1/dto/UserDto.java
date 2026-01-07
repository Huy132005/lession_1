package lession1.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lession1.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto {
    private Long id;

    private String username;

    private String email;

    private String password;

    private User.Role role;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
