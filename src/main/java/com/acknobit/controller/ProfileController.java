package com.acknobit.controller;

import com.acknobit.entity.Profile;
import com.acknobit.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
public class ProfileController {
    private static final long MAX_IMAGE_SIZE = 5 * 1024 * 1024;

    private ProfileRepository profileRepository;
    @Value("${upload-dir}")
    private String uploadDir;

    @Autowired
    public ProfileController(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }



    @PutMapping(value = "/{id}", consumes = {"multipart/form-data"})
    public ResponseEntity<?> updateProfile(
            @PathVariable Long id,
            @RequestPart("profile") Profile updatedData,
            @RequestPart(value = "avatar", required = false) MultipartFile avatarFile) throws IOException {



        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        profile.setFullName(updatedData.getFullName());
        profile.setEmail(updatedData.getEmail());
        profile.setPhone(updatedData.getPhone());




        if (avatarFile != null && !avatarFile.isEmpty() ) {
            if (avatarFile.getSize() > MAX_IMAGE_SIZE) {
                return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE)
                        .body("Image size exceeds the maximum allowed limit of 5MB.");
            }

            String contentType = avatarFile.getContentType();
            if (contentType == null || !contentType.startsWith("image/")) {
                return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body("Only image files are allowed.");
            }

              java.io.File directory = new java.io.File(uploadDir);
              if(!directory.exists()){
                 directory.mkdirs();
              }

            String fileName = UUID.randomUUID() + "_" + avatarFile.getOriginalFilename();
            Path filePath = Paths.get(uploadDir, fileName);
            Files.write(filePath, avatarFile.getBytes());

            profile.setAvatarUrl("/uploads/" + fileName);


    }
        Profile saved = profileRepository.save(profile);
        return ResponseEntity.ok(saved);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfile(@PathVariable Long id) {
        return profileRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    }