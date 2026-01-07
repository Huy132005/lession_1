package lession1.service;

import lession1.dto.LoginResponseDto;
import lession1.form.LoginForm;

public interface AuthService {
    LoginResponseDto login(LoginForm form);
}
