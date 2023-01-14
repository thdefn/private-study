package com.haden.prjforstd.demo.controller;

import com.haden.prjforstd.demo.domain.entity.NotifyType;
import com.haden.prjforstd.demo.service.UserService;
import com.haden.prjforstd.demo.controller.dto.SigninForm;
import com.haden.prjforstd.demo.controller.dto.SignupForm;
import com.haden.prjforstd.demo.controller.dto.TokenRefreshForm;
import com.haden.prjforstd.fcm.FcmService;
import com.haden.prjforstd.fcm.FcmServiceDto;
import com.haden.prjforstd.effectivejava.security.JwtUtil;
import com.haden.prjforstd.effectivejava.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private final UserService userService;

    @Autowired
    private final FcmService fcmService;

    @Autowired
    JwtUtil jwtUtil;

    public UserController(UserService userService, FcmService fcmService) {
        this.userService = userService;
        this.fcmService = fcmService;
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
    public ResponseEntity readToken(@RequestParam String username){
        return ResponseEntity.ok(userService.readToken(username));
    }

    @GetMapping("/push")
    public void fcmTest(@AuthenticationPrincipal UserDetailsImpl userDetails){
        FcmServiceDto dto = FcmServiceDto.of(userDetails.getUsername(),1L, NotifyType.NOTICE,"제목", "콘텐츠");
        fcmService.sendByToken(dto);
    }
}
