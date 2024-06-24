package com.forohub.ForoHub_API.REST.controller;
import com.forohub.ForoHub_API.REST.domain.usuarios.UserForo;
import com.forohub.ForoHub_API.REST.dto.UserForoDTO;
import com.forohub.ForoHub_API.REST.services.UserForoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserForoController {
    @Autowired
    private UserForoService userService;

    @GetMapping
    public ResponseEntity<List<UserForo>> getAllUsers() {
        List<UserForo> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserForo> getUserById(@PathVariable Long id) {
        UserForo user = userService.getUserById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<UserForo> createUser(@RequestBody UserForoDTO dto) {
        UserForo createdUser = userService.createUser(dto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserForo> updateUser(@PathVariable Long id, @RequestBody UserForoDTO dto){
        UserForo userUpdated = userService.updateUser(id, dto);
        if (userUpdated == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userUpdated, HttpStatus.OK);

    }


}