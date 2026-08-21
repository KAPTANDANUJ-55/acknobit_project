package com.acknobit.controller;

import com.acknobit.dto.Login;
import com.acknobit.dto.Register;
import com.acknobit.service.CredentialService;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Admin")
@CrossOrigin(origins = "*")
public class AdminController {
    private final CredentialService adminService;
    public AdminController(CredentialService adminService) {
        this.adminService = adminService;
    }

      @PostMapping("/register")
 public ResponseEntity<?> register(@RequestBody Register register) {
         return   adminService.register(register);
      }

      @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login login) {return adminService.login(login);}


}
