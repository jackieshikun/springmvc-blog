package com.springmvcblog.repository;


import com.springmvcblog.model.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("select c from Comment c join c.blog b where b.id = ?1")
    List<Comment> findAll(Long blogId, Sort sort);
}
