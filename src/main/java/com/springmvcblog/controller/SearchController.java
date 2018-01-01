package com.springmvcblog.controller;

import com.springmvcblog.model.Blog;
import com.springmvcblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/search")
    public List<Blog> search(@RequestParam("key") String key) {
        // Your code goes here
        List<Blog> list = blogService.findBlogsByKey(key);
        return null;
    }
}
