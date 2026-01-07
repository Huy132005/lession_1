package lession1.service.impl;

import lession1.dto.UserDto;
import lession1.entity.User;
import lession1.form.UserCreateForm;
import lession1.repository.UserRepository;
import lession1.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    private ModelMapper modelMapper;
    @Override
    public UserDto create(UserCreateForm form){
        var user = modelMapper.map(form, User.class);
        var encodedPassword = passwordEncoder.encode(form.getPassword());
        user.setPassword(encodedPassword);
        var savedUse = userRepository.save(user);
        return modelMapper.map(savedUse, UserDto.class);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUsernameOrEmail(username, username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        var role= user.getRole();
        var authorities = AuthorityUtils.createAuthorityList(String.valueOf(role));

        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);
    }
}
