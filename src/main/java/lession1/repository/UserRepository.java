package lession1.repository;

import lession1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //ADMIN, EMPLOYEE, MANGER;
    //A-1
    //A-2
    //E-1
    //E-2
    //M-1
    //M-2

    long countByRole(User.Role role);

    User findByUsernameOrEmail(String username, String email);

    Optional<User> findByUsername(String username);

}
