package com.acknobit.dto;

public record LeadRequests(
        String fullName,
        String phoneNumber,
        String email,
        String service,
        String budget,
        String projectDescription
) {
}
