package com.springSecurityForVersion3.controller;


import jakarta.annotation.security.PermitAll;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/normal")
    @PreAuthorize("hasRole('NORMAL')")
    public ResponseEntity<String> normalUser(){
        return ResponseEntity.ok("I am a normal User");
    }
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> adminUser(){
        return ResponseEntity.ok("I am a Admin User");
    }
    @GetMapping("/public")
    @PermitAll
    public ResponseEntity<String> publicUser(){
        return ResponseEntity.ok("I am a public User");
    }
}
