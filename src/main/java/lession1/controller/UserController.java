package lession1.controller;

import jakarta.validation.Valid;
import lession1.dto.LoginResponseDto;
import lession1.dto.UserDto;
import lession1.entity.User;
import lession1.form.LoginForm;
import lession1.form.UserCreateForm;
import lession1.service.AuthService;
import lession1.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@Validated
@RestController
@AllArgsConstructor
public class UserController {
    private UserService service;
    private AuthService authService;
    @PostMapping("api/v1/auth/register")
    public UserDto create(@RequestBody @Valid UserCreateForm form){
          return service.create(form);
    }
    @PostMapping("api/v1/auth/login")
    public ResponseEntity<LoginResponseDto> login(
            @RequestBody LoginForm form
    ) {
        return ResponseEntity.ok(authService.login(form));
    }
}
