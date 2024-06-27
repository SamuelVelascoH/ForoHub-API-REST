package com.forohub.ForoHub_API.REST.repository;

import com.forohub.ForoHub_API.REST.domain.usuarios.UserForo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserForoRepository extends JpaRepository<UserForo, Long> {
}
