package com.example.kyudo_app.presentation.controller;

import com.example.kyudo_app.domain.model.User;
import com.example.kyudo_app.domain.service.UserRegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:5173")
public class UserResistorController {

private final UserRegisterService userRegisterService;

public UserResistorController(UserRegisterService userRegisterService){
    this.userRegisterService = userRegisterService;
}

    @GetMapping("/user")

    public String getUsers() {
        return "ユーザー一覧";
    }
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User registeredUser = userRegisterService.registryUser(user);
        return ResponseEntity.ok(registeredUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userRegisterService.getUserById(id);
        return ResponseEntity.ok(user);
    }


}

