package com.forohub.ForoHub_API.REST.dto;

public record UserForoDTO(
        Long id,
        String email,
        String userName,
        String password
) {
}
