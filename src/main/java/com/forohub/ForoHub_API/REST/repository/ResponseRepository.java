package com.forohub.ForoHub_API.REST.repository;

import com.forohub.ForoHub_API.REST.domain.topics.Response;
import com.forohub.ForoHub_API.REST.domain.topics.Topic;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResponseRepository extends JpaRepository<Response, Long> {
    @EntityGraph(attributePaths = {"topic_id"})
    @Query("SELECT t FROM response t")
    List<Response> findAllTopicsWithAuthors();
}
