package com.acknobit.dto;

    public record LeadResponses(
            boolean success,
            String message,
            String redirectUrl
    ) {}

