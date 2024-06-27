package com.forohub.ForoHub_API.REST.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.forohub.ForoHub_API.REST.domain.topics.Response;
import com.forohub.ForoHub_API.REST.domain.topics.Topic;

import java.time.LocalDateTime;

public record ResponseDTO(
        String responseTitle,
        String body,
        String author,
        LocalDateTime creationDate
) {


}
