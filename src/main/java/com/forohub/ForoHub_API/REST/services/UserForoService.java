package com.forohub.ForoHub_API.REST.services;

import com.forohub.ForoHub_API.REST.domain.usuarios.UserForo;
import com.forohub.ForoHub_API.REST.dto.UserForoDTO;
import com.forohub.ForoHub_API.REST.repository.UserForoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserForoService {

    @Autowired
    private UserForoRepository userRepository;

    public List<UserForo> getAllUsers() {
        return userRepository.findAll();
    }

    public UserForo getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserForo createUser(UserForoDTO dto) {
        UserForo user = new UserForo(dto.id(),
                dto.email(),
                dto.userName(),
                dto.password());
        return userRepository.save(user);
    }
    public UserForo updateUser(Long id, UserForoDTO dto) {
        Optional<UserForo> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()){
            UserForo user = existingUser.get();
            user.setId(dto.id());
            user.setEmail(dto.email());
            user.setUserName(dto.userName());
            user.setPassword(dto.password());
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
