package com.forohub.ForoHub_API.REST.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationUserApiDTO(
        @NotBlank
        String login,
        @NotBlank
        String key) {
}
