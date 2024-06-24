package com.forohub.ForoHub_API.REST.controller;

import com.forohub.ForoHub_API.REST.domain.topics.Response;
import com.forohub.ForoHub_API.REST.dto.ResponseDTO;
import com.forohub.ForoHub_API.REST.services.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/response")
public class ResponseController {
    @Autowired
    private ResponseService responseService;

    @GetMapping
    public ResponseEntity<List<ResponseDTO>> getAllResponses() {
        List<ResponseDTO> responseDTOs = responseService.getAllResponses();
        return new ResponseEntity<>(responseDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getResponseById(@PathVariable Long id) {
        ResponseDTO responseDTO = responseService.getResponseById(id);
        if (responseDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Response> createResponse(@PathVariable Long id,@RequestBody ResponseDTO responseDTO) {
        Response newResponse = responseService.createResponse(id, responseDTO);
        return new ResponseEntity<>(newResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> updateResponse(@PathVariable Long id, @RequestBody ResponseDTO responseDTO) {
        Response updatedResponse = responseService.updateResponse(id, responseDTO);
        if (updatedResponse == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResponse(@PathVariable Long id) {
        boolean isDeleted = responseService.deleteResponse(id);
        if (!isDeleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

