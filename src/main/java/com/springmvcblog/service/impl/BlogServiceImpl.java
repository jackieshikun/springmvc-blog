package com.springmvcblog.service.impl;

import com.springmvcblog.ErrorHandler.BlogNotFoundException;
import com.springmvcblog.model.Blog;
import com.springmvcblog.model.User;
import com.springmvcblog.repository.BlogRepository;
import com.springmvcblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;



    @Override
    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog findBlog(long id) {
        Blog blog = blogRepository.findOne(id);
        if(blog == null)
            throw new BlogNotFoundException("blog not found");
        return blog;
    }

    @Override
    public Blog updateBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void deleteBlog(Blog blog) {

        blogRepository.delete(blog);
    }

    @Override
    public List<Blog> findBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public List<Blog> findBlogs(User user) {
        return null;
    }

    @Override
    public List<Blog> findBlogs(User user, Date startDate, Date endDate) {
        return null;
    }

    @Override
    public Page<Blog> findBlogs(Pageable pageable) {
        return null;
    }

    @Override
    public Page<Blog> findBlogs(User user, Pageable pageable) {
        return blogRepository.findAll(user.getId(), pageable);
    }

    @Override
    public List<Blog> findBlogsByTag(String tag) {
        return null;
    }

    @Override
    public List<Blog> findBlogs(String email) {
        return null;
    }

    @Override
    public Page<Blog> findBlogsByTag(String tag, Pageable pageable) {
        return null;
    }

    @Override
    public List<Blog> findBlogsByKey(String key){
        return null;
    }
}
