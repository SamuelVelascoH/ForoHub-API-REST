package com.forohub.ForoHub_API.REST.repository;

import com.forohub.ForoHub_API.REST.domain.topics.Response;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseRepository extends JpaRepository<Response, Long> {
}
