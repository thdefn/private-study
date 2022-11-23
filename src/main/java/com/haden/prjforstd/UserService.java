package com.haden.prjforstd;

import com.haden.prjforstd.security.JwtUtil;
import com.haden.prjforstd.security.TokenDto;
import com.haden.prjforstd.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    @Value("${haden.admintoken}")
    private String ADMINTOKEN;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

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

        User user = User.from(form, passwordEncoder.encode(form.getPassword()), role);
        return userRepository.save(user);
    }

    public List<User> searchUser() {
        return userRepository.findAllByUsernameContaining("ha");
    }

    public TokenDto loginUser(SigninForm form) {
        User user = userRepository.findByUsername(form.getUsername())
                .orElseThrow(()->new IllegalArgumentException("유저가 존재하지 않음"));

        //유저가 존재하면
        if(passwordEncoder.matches(form.getPassword(), user.getPassword())){ //패스워드 확인 후 맞으면
                //토큰 발급
                return jwtUtil.generateToken(user.getUsername());
        }

        throw new IllegalArgumentException("패스워드가 다름");
    }
}
