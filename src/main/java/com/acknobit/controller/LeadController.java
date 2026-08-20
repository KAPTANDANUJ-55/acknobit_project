package com.acknobit.controller;

import com.acknobit.dto.LeadRequests;
import com.acknobit.dto.LeadResponses;
import com.acknobit.entity.Lead;
import com.acknobit.repository.LeadRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/leads")
@CrossOrigin(origins = "*")
public class LeadController {

    private final LeadRepository leadRepository;

    public LeadController(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    @PostMapping("/submit")
    public ResponseEntity<LeadResponses> submitLead(@RequestBody LeadRequests request) {


        Lead lead = new Lead(
                request.fullName(),
                request.email(),
                request.phoneNumber(),
                request.service(),
                request.budget(),
                request.projectDescription()
        );
        leadRepository.save(lead);


        LeadResponses response = new LeadResponses(
                true,
                "Thank you! Redirecting to services portal...",
                "/main.html"
        );

        return ResponseEntity.ok(response);
    }
}