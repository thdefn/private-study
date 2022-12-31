package com.haden.prjforstd;

import com.haden.prjforstd.security.JwtUtil;
import com.haden.prjforstd.security.TokenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final TokenRefreshRepository tokenRefreshRepository;
    private final TokenRepository tokenRepository;
    @Value("${haden.admintoken}")
    private String ADMINTOKEN;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    public UserService(UserRepository userRepository, TokenRefreshRepository tokenRefreshRepository, TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.tokenRefreshRepository = tokenRefreshRepository;
        this.tokenRepository = tokenRepository;
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
                TokenDto dto = jwtUtil.generateToken(user.getUsername());
                tokenRepository.save(Token.of(user.getUsername(),dto.getRefreshToken()));
                //tokenRefreshRepository.save(RefreshToken.of(dto.getRefreshToken(),user));
                return dto;
        }

        throw new IllegalArgumentException("패스워드가 다름");
    }

    public TokenDto tokenRefresh(TokenRefreshForm form) {
        Token token = tokenRepository.findByUsername(form.getUsername()).orElse(null);
        if(token!= null){
            if(token.getTokenValue().equals(form.getRefreshToken())){
                TokenDto dto = jwtUtil.generateToken(token.getUsername());
                tokenRepository.delete(token);
                tokenRepository.save(Token.of(token.getUsername(),dto.getRefreshToken()));
                return dto;
            }
            else{
                throw new IllegalArgumentException("refersh 토큰이 다릅니다.");
            }

        }else{
            throw new IllegalArgumentException("권한 정보가 없는 유저입니다.");
        }
    }

    @Cacheable(key = "#username", cacheNames = "Token")
    public String readToken(String username) {
        Token token = tokenRepository.findByUsername(username)
                .orElseThrow(()->new IllegalArgumentException("해당 토큰이 존재하지 않음"));
        return token.getTokenValue();
    }
}
