package com.starter.auth;

import com.starter.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> Register(@RequestBody @Valid CreateUserDto createUserDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(bindingResult.getAllErrors().toString()));
        return authService.createUserFromRegister(createUserDto);
    }

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok(new MessageResponse("test"));
    }
}
