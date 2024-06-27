package com.forohub.ForoHub_API.REST.dto;

import java.time.LocalDateTime;

public record ResponseDTOWithoutTopic(
         Long id,
         String responseTitle,
         String body,
         String responseAuthor,
         LocalDateTime creationDate) {
}
