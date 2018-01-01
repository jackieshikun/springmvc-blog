package com.springmvcblog.repository;


import com.springmvcblog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface BlogRepository extends JpaRepository<Blog, Long>{
    @Query("select b from Blog b join b.author u where u.id = ?1")
    Page<Blog> findAll(Long userId, Pageable pageable);
}
