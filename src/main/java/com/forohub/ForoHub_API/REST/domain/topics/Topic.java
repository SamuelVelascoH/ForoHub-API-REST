package com.forohub.ForoHub_API.REST.domain.topics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.forohub.ForoHub_API.REST.domain.usuarios.UserForo;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity(name = "topic")
@Table(name = "topics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String body;
    private String courseName;
    private String author;

    @CreatedDate
    private LocalDateTime creationDate;

}
