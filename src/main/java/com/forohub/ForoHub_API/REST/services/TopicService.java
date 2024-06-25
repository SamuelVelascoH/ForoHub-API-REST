package com.forohub.ForoHub_API.REST.services;

import com.forohub.ForoHub_API.REST.domain.topics.Topic;
import com.forohub.ForoHub_API.REST.dto.TopicDTO;
import com.forohub.ForoHub_API.REST.infra.security.AuthenticationService;
import com.forohub.ForoHub_API.REST.repository.TopicRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private ExistingValidationTopic existingValidationTopic;

    public List<TopicDTO> getAllTopics() {
        List<Topic> topics = topicRepository.findAllTopicsWithAuthors();
        return topics.stream()
                .map(topic -> {
                    String authorName = (topic.getAuthor() != null) ? topic.getAuthor() : "Desconocido";
                    return new TopicDTO(
                            topic.getId(),
                            topic.getTitle(),
                            topic.getBody(),
                            topic.getCourseName(),
                            authorName,
                            topic.getCreationDate());
                })
                .collect(Collectors.toList());
    }

    public TopicDTO getTopicById(Long id) {
        Topic topic = topicRepository.findById(id).orElse(null);
        if (topic != null) {
            String authorName = (topic.getAuthor() != null) ? topic.getAuthor() : "Desconocido";
            return new TopicDTO(
                    topic.getId(),
                    topic.getTitle(),
                    topic.getBody(),
                    topic.getCourseName(),
                    authorName,
                    topic.getCreationDate());
        }
        return null;
    }

    public Topic createTopic(TopicDTO dto) {
        Topic topic = new Topic();
        topic.setTitle(dto.title());
        topic.setBody(dto.body());
        topic.setCourseName(dto.courseName());
        topic.setCreationDate(LocalDateTime.now());
        var author = authenticationService.getNameAuthenticatedUser();
        topic.setAuthor(author);
        if (existingValidationTopic.existingValidation(topic.getTitle(), topic.getBody())) {
            return null;
        }
        return topicRepository.save(topic);
    }

    public Topic updateTopic(Long id, TopicDTO dto) {
        Optional<Topic> existingTopic = topicRepository.findById(id);
        if (existingTopic.isPresent()) {
            Topic topic = existingTopic.get();
            topic.setTitle(dto.title());
            topic.setBody(dto.body());
            topic.setCourseName(dto.courseName());
            var author = authenticationService.getNameAuthenticatedUser();
            topic.setAuthor(author);
            topic.setCreationDate(LocalDateTime.now());
            if (existingValidationTopic.existingValidation(topic.getTitle(), topic.getBody())){
                return null;
            }
            return topicRepository.save(topic);
        }
        throw new EntityNotFoundException("No se encontró el Topic con id: " + id);
    }

    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }

}
