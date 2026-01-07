package lession1.converter;

import jakarta.persistence.AttributeConverter;
import lession1.entity.User;

public class UserRoleConverter implements AttributeConverter<User.Role, Character> {
    @Override
    public Character convertToDatabaseColumn(User.Role role) {
        return role.toString().charAt(0);
    }

    @Override
    public User.Role convertToEntityAttribute(Character code) {
        if(code == 'A'){
            return User.Role.ADMIN;
        } if(code == 'E'){
            return User.Role.EMPLOYEE;
        }
        return User.Role.MANGER;
    }
}
