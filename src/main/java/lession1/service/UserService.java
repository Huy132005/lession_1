package lession1.service;

import lession1.dto.UserDto;
import lession1.form.UserCreateForm;

public interface UserService {
    UserDto create(UserCreateForm form);
}
