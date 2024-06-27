package com.forohub.ForoHub_API.REST.services;

import com.forohub.ForoHub_API.REST.domain.topics.Response;
import com.forohub.ForoHub_API.REST.dto.ResponseDTO;
import com.forohub.ForoHub_API.REST.infra.security.AuthenticationService;
import com.forohub.ForoHub_API.REST.repository.ResponseRepository;
import com.forohub.ForoHub_API.REST.repository.TopicRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResponseService {
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private ResponseRepository responseRepository;
    @Autowired
    private TopicRepository topicRepository;
    public List<ResponseDTO> getAllResponses() {
        List<Response> responses = responseRepository.findAll();
        return responses.stream()
                .map(response -> {
                    String author = (response.getResponseAuthor() != null) ? response.getResponseAuthor() : "Desconocido";
                    return new ResponseDTO(
                            response.getResponseTitle(),
                            response.getBody(),
                            author,
                            response.getCreationDate());
                })
                .collect(Collectors.toList());
    }

    public ResponseDTO getResponseById(Long id) {
        Response response = responseRepository.findById(id).orElse(null);
        if (response != null){
            return  new ResponseDTO(
                    response.getResponseTitle(),
                    response.getBody(),
                    response.getResponseAuthor(),
                    response.getCreationDate());
        }
        return null;
    }

    public Response createResponse(Long id, ResponseDTO dto) {
        var author = authenticationService.getNameAuthenticatedUser();
        if (topicRepository.findById(id).isPresent()){
        Response response = new Response();
        response.setTopic(topicRepository.getReferenceById(id));
        response.setResponseAuthor(author);
        response.setResponseTitle(dto.responseTitle());
        response.setBody(dto.body());
        response.setCreationDate(LocalDateTime.now());
        return responseRepository.save(response);
        }
        return new Response();
    }

        public Response updateResponse (Long id, ResponseDTO dto){
            Optional<Response> existingResponse = responseRepository.findById(id);
            if (existingResponse.isPresent()) {
                Response newResponse = existingResponse.get();
                newResponse.setResponseTitle(dto.responseTitle());
                newResponse.setBody(dto.body());
                var author = authenticationService.getNameAuthenticatedUser();
                newResponse.setResponseAuthor(author);
                newResponse.setCreationDate(LocalDateTime.now());
                return responseRepository.save(newResponse);
            }
            throw new EntityNotFoundException("No se encontró el Topic con id: " + id);
        }

        public boolean deleteResponse (Long id){
            if (responseRepository.existsById(id)) {
                responseRepository.deleteById(id);
                return true;
            }
            return false;
        }
    }

