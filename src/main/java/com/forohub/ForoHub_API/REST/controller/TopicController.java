package com.forohub.ForoHub_API.REST.controller;

import com.forohub.ForoHub_API.REST.domain.topics.Topic;
import com.forohub.ForoHub_API.REST.dto.TopicDTO;
import com.forohub.ForoHub_API.REST.errors.CustomConflictException;
import com.forohub.ForoHub_API.REST.services.TopicService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {
    @Autowired
    public TopicService topicService;
    @GetMapping
    public ResponseEntity<List<TopicDTO>> getAllTopics() {
        List<TopicDTO> topicsDTO = topicService.getAllTopics();
        return new ResponseEntity<>(topicsDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicDTO> getTopicById(@PathVariable Long id) {
        try {
            TopicDTO topicDTO = topicService.getTopicById(id);
            return new ResponseEntity<>(topicDTO, HttpStatus.OK);
        } catch (EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Topic> createTopic(@RequestBody TopicDTO dto) {
        try {
            Topic createdTopic = topicService.createTopic(dto);
            return new ResponseEntity<>(createdTopic, HttpStatus.CREATED);
        } catch (CustomConflictException e) {
             return new ResponseEntity<>(e.getStatus());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topic> updateTopic(@PathVariable Long id, @RequestBody TopicDTO dto) {
        try {
            Topic updatedTopic = topicService.updateTopic(id, dto);
            return new ResponseEntity<>(updatedTopic, HttpStatus.OK);
        } catch (CustomConflictException e) {
            return new ResponseEntity<>(e.getStatus());
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

