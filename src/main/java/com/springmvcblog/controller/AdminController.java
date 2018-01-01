package com.springmvcblog.controller;


import com.springmvcblog.model.Blog;
import com.springmvcblog.model.User;
import com.springmvcblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private BlogService blogService;
    @GetMapping
    public String getAdmin(@ModelAttribute("message") String message,
                           @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                           @RequestParam(value = "size", required = false, defaultValue = "5") int size,
                           Model model,
                           HttpSession session){
        User user = (User)session.getAttribute("CURRENT_USER");
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(page-1, size, sort);
        Page<Blog> list = blogService.findBlogs(user, pageable);
        model.addAttribute("blogList", list);
        model.addAttribute("username", user.getName());
        return "admin";
    }
}
