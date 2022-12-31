package com.haden.prjforstd;

import com.haden.prjforstd.security.JwtUtil;
import com.haden.prjforstd.security.TokenDto;
import com.haden.prjforstd.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private final UserService userService;

    @Autowired
    JwtUtil jwtUtil;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/auth/signup")
    public ResponseEntity registerUser(@RequestBody SignupForm form){
        return ResponseEntity.ok(userService.registerUser(form));
    }

    @PostMapping("/auth/signin")
    public ResponseEntity loginUser(@RequestBody SigninForm form){
        return ResponseEntity.ok(userService.loginUser(form));
    }

    @GetMapping("/user/search")
    public void searchUser(@AuthenticationPrincipal UserDetailsImpl userDetails){
        System.out.println("username: " +userDetails.getUsername());
        System.out.println("pwd: " +userDetails.getPassword());
    }

    @PostMapping("/auth/refresh")
    public ResponseEntity tokenRefresh(@RequestBody TokenRefreshForm form){
        return ResponseEntity.ok(userService.tokenRefresh(form));
    }

    @GetMapping("/auth/read")
    public ResponseEntity readToken(@AuthenticationPrincipal UserDetailsImpl userDetails){
        return ResponseEntity.ok(userService.readToken(userDetails.getUsername()));
    }
}
