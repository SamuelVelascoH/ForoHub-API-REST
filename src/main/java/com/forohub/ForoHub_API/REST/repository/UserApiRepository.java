package com.forohub.ForoHub_API.REST.repository;

import com.forohub.ForoHub_API.REST.domain.usuarios.UserAPI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserApiRepository extends JpaRepository<UserAPI, Long> {
}
