package com.haden.prjforstd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/signup")
    public ResponseEntity registerUser(@RequestBody SignupForm form){
        return ResponseEntity.ok(userService.registerUser(form));
    }

    @GetMapping("/user/search")
    public ResponseEntity searchUser(){
        return ResponseEntity.ok(userService.searchUser());
    }
}
