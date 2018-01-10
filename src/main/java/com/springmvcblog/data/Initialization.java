package com.springmvcblog.data;

import com.springmvcblog.model.Blog;
import com.springmvcblog.model.User;
import com.springmvcblog.service.BlogService;
import com.springmvcblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Initialization implements CommandLineRunner {

    private final UserService userService;

    private final BlogService blogService;

    @Autowired
    public Initialization(UserService userService, BlogService blogService) {
        this.userService = userService;
        this.blogService = blogService;
    }

    @Override
    public void run(String... strings) throws Exception {
        if(userService.findByEmail("jackyshikun@gmail.com") == null){
            User user = new User("shikun", "jackyshikun@gmail.com");
            user.setPassword("123456");
            userService.register(user);
            createBlog("Hello world", "Welcome to blog", user);
        }
    }

    private User createUser(String name, String email) {
        User user = new User(name, email);
        user.setPassword("123456");
        return userService.register(user);
    }

    private Blog createBlog(String title, String content, User author) {
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        blog.setAuthor(author);
        blog.setCreatedTime(new Date());

        return blogService.createBlog(blog);
    }

}