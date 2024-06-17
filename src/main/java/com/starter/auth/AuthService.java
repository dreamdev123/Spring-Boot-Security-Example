package com.starter.auth;

import com.starter.utils.DtoEntity;
import com.starter.utils.DtoUtils;
import com.starter.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AuthRepo authRepo;

    public ResponseEntity<?> createUserFromRegister(DtoEntity createUserDto) {
        try {
            User user = (User) new DtoUtils().converToEntity(new User(), createUserDto);
            if (!authRepo.existsByEmail(user.getEmail())) {
                user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
                authRepo.save(user);
                return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
            } else {
                return ResponseEntity
                        .badRequest()
                        .body(new MessageResponse("Error: Username is already taken!"));
            }
        }catch (Exception e){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: " + e.getMessage()));
        }

    }
}
