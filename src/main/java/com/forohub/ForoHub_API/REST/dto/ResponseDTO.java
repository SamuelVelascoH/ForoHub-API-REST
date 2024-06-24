package com.forohub.ForoHub_API.REST.dto;

import com.forohub.ForoHub_API.REST.domain.topics.Topic;

import java.time.LocalDateTime;

public record ResponseDTO(
        Topic idTopic,
        String responseTitle,
        String body,
        String author,
        LocalDateTime creationDate) {
}
