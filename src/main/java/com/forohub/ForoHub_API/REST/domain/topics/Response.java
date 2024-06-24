package com.forohub.ForoHub_API.REST.domain.topics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.forohub.ForoHub_API.REST.domain.usuarios.UserForo;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity(name = "response")
@Table(name = "responses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic idTopic;

    private String responseTitle;

    private String responseAuthor;

    private String body;

    @CreatedDate
    private LocalDateTime creationDate;

}
