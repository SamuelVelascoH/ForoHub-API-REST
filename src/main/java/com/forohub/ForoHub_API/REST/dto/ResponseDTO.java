package com.forohub.ForoHub_API.REST.dto;

import java.time.LocalDateTime;

public record ResponseDTO(
        String responseTitle,
        String body,
        String author,
        LocalDateTime creationDate
) {


}
