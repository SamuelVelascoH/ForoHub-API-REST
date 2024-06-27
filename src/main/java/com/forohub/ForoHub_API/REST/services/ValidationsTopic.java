package com.forohub.ForoHub_API.REST.services;

import com.forohub.ForoHub_API.REST.domain.topics.Topic;
import com.forohub.ForoHub_API.REST.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidationsTopic {
    @Autowired
    TopicRepository topicRepository;
    public boolean existingValidation(String title, String body){
        Long existingTitleCount = topicRepository.countByTitle(title);
        Long existingBobyCount = topicRepository.countByBody(body);
        if (existingTitleCount > 0 && existingBobyCount > 0 ) {
            System.out.println("El tema '" + title + " "+body+" ya ha sido creado :( .");
            return true;
        } else return false;
    }
}
