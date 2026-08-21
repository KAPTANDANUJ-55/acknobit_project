package com.acknobit.service;

import com.acknobit.dto.Login;
import com.acknobit.dto.Register;
import com.acknobit.entity.Admin;
import com.acknobit.repository.CredoRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
import java.util.Optional;
@Service
public class CredentialService {
    private final CredoRepo credoRepo;
    private final PasswordEncoder passwordEncoder;

    public CredentialService(CredoRepo credoRepo, PasswordEncoder passwordEncoder) {
        this.credoRepo = credoRepo;
        this.passwordEncoder = passwordEncoder;
    }

   public ResponseEntity<?> register(@RequestBody Register register) {
       Optional<Admin> existingAdmin = credoRepo.findByEmail(register.getEmail());
       if (existingAdmin.isPresent()) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists");
       }

       String encodedPassword = passwordEncoder.encode(register.getPassword());
       Admin admin = Admin.builder().
               Username(register.getUsername()).
               email(register.getEmail()).
               password(encodedPassword).
               build();


       credoRepo.save(admin);


       return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
               "id", admin.getId(),
               "message", "Admin Registered Successfully"
       ));
   }

    public ResponseEntity<?> login(Login login) {

        Optional<Admin> existingUser = credoRepo.findByEmail(login.getEmail());

        if (existingUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("USER NOT FOUND.PLEASE REGISTER");
        }

        Admin admin =  existingUser.get();

        boolean matches = passwordEncoder.matches(
                login.getPassword(),
                admin.getPassword()
        );
        if (!matches) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "PASSWORD IS INCORRECT"));
        }

        return ResponseEntity.ok(Map.of(
                "id", admin.getId(),
                "email", admin.getEmail(),
                "username", admin.getUsername() != null ? admin.getUsername() : "",
                "message", "LOGIN SUCCESSFULLY"
        ));
    }

}
