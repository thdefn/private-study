package com.haden.prjforstd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    @Value("${haden.admintoken}")
    private String ADMINTOKEN;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(SignupForm form) {
        Optional<User> found = userRepository.findByUsername(form.getUsername());
        if(found.isPresent()){
            throw new IllegalArgumentException("중복중복");
        }

        UserRoleEnum role = UserRoleEnum.USER;

        if(form.getAdminToken().equals(ADMINTOKEN)){
            role = UserRoleEnum.ADMIN;
        }

        User user = User.from(form, role);
        return userRepository.save(user);
    }

    public List<User> searchUser() {
        return userRepository.findAllByUsernameContaining("ha");
    }
}
