package com.forohub.ForoHub_API.REST.repository;

import com.forohub.ForoHub_API.REST.domain.topics.Topic;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    @EntityGraph(attributePaths = {"author"})
    @Query("SELECT t FROM topic t")
    List<Topic> findAllTopicsWithAuthors();

    @Query("SELECT COUNT(t) FROM topic t WHERE t.title = :title")
    Long countByTitle(@Param("title") String title);

    @Query("SELECT COUNT(t) FROM topic t WHERE t.body = :body")
    Long countByBody(@Param("body")String body);
}

