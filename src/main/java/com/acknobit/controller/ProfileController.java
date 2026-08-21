package com.acknobit.controller;

import com.acknobit.entity.Profile;
import com.acknobit.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
@RequestMapping("/profile")
@CrossOrigin(origins = "*")
public class ProfileController {
    private static final long MAX_IMAGE_SIZE = 5 * 1024 * 1024;

    private final ProfileRepository profileRepository;

    @Value("${upload-dir:uploads/}")
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

        Profile profile = profileRepository.findById(id).orElseGet(() -> {
            Profile newProfile = new Profile();
            newProfile.setId(id);
            return newProfile;
        });

        if (updatedData.getFullName() != null) profile.setFullName(updatedData.getFullName());
        if (updatedData.getEmail() != null) profile.setEmail(updatedData.getEmail());
        if (updatedData.getPhone() != null) profile.setPhone(updatedData.getPhone());

        if (avatarFile != null && !avatarFile.isEmpty()) {
            if (avatarFile.getSize() > MAX_IMAGE_SIZE) {
                return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE)
                        .body("Image size exceeds the maximum allowed limit of 5MB.");
            }

            String contentType = avatarFile.getContentType();
            if (contentType == null || !contentType.startsWith("image/")) {
                return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
                        .body("Only image files are allowed.");
            }

            File directory = new File(uploadDir);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String originalName = avatarFile.getOriginalFilename() != null ? avatarFile.getOriginalFilename() : "avatar.png";
            String fileName = UUID.randomUUID() + "_" + originalName.replaceAll("\\s+", "_");
            Path filePath = Paths.get(uploadDir, fileName);
            Files.write(filePath, avatarFile.getBytes());

            profile.setAvatarUrl("/uploads/" + fileName);
        }

        Profile saved = profileRepository.save(profile);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfile(@PathVariable Long id) {
        Profile profile = profileRepository.findById(id).orElseGet(() -> {
            Profile defaultProfile = new Profile();
            defaultProfile.setId(id);
            return defaultProfile;
        });
        return ResponseEntity.ok(profile);
    }
}