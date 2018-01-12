package com.springmvcblog.controller;

import com.springmvcblog.model.Blog;
import com.springmvcblog.model.User;
import com.springmvcblog.service.BlogService;
import com.springmvcblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    private final BlogService blogService;

    @Autowired
    private UserService userService;

    @Autowired
    public IndexController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/{username}")
    public String getByPage(@PathVariable("username") String username,
                            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                            @RequestParam(value = "size", required = false, defaultValue = "5") int size,
                            Model model) {
        User user = userService.findByName(username);
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(page-1, size, sort);
        Page<Blog> list = blogService.findBlogs(userService.findByName(username), pageable);
        model.addAttribute("blogList", list);
        model.addAttribute("username", username);
        model.addAttribute("email",user.getEmail());
        model.addAttribute("intro", user.getIntro());
        return "list";
    }

    @GetMapping("/")
    public String index(HttpSession session){
        User user = (User)session.getAttribute("CURRENT_USER");
        if(user != null)
            return "redirect:/" + user.getName();
        return "redirect:/shikun";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }

}