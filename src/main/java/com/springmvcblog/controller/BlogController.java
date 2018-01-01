package com.springmvcblog.controller;

import com.springmvcblog.form.BlogCreateForm;
import com.springmvcblog.form.CommentForm;
import com.springmvcblog.model.Blog;
import com.springmvcblog.model.Comment;
import com.springmvcblog.model.User;
import com.springmvcblog.service.BlogService;
import com.springmvcblog.service.CommentService;
import com.springmvcblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @GetMapping("/blogs/{id}")
    public String get(@PathVariable("id") long id,
                      Model model){
        Blog blog = blogService.findBlog(id);
        List<Comment> comments = commentService.getCommentOfBlog(blog);
        model.addAttribute("blog", blog);
        model.addAttribute("commentList", comments);
        model.addAttribute("comment", new CommentForm());
        model.addAttribute("id", id);
        User user = blog.getAuthor();
        model.addAttribute("username", user.getName());
        model.addAttribute("email",user.getEmail());
        model.addAttribute("intro", user.getIntro());
        return "item";
    }

    @GetMapping("/blogs/{id}/edit")
    public String edit(@PathVariable("id") long id,
                       Model model,
                       HttpSession session){
        Blog blog = blogService.findBlog(id);
        BlogCreateForm form = new BlogCreateForm();
        form.setId(id);
        form.setSummary(blog.getSummary());
        form.setContent(blog.getContent());
        form.setTitle(blog.getTitle());
        model.addAttribute("blog", form);
        User user = (User)session.getAttribute("CURRENT_USER");
        model.addAttribute("user", user);
        model.addAttribute("EDIT", true);
        return "create";
    }

    @PutMapping("/blogs/{id}")
    public String editBlog(@PathVariable("id") long id,
                           Model model,
                           @ModelAttribute("blog") @Valid BlogCreateForm form,
                           BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("EDIT", true);
            return "create";
        }
        Blog blog = blogService.findBlog(id);
        blog.setContent(form.getContent());
        blog.setTitle(form.getTitle());
        blog.setCreatedTime(new Date());
        blogService.updateBlog(blog);
        return "redirect:/blogs/" + id;
    }

    @DeleteMapping("/blogs/{id}")
    public String deleteBlog(@PathVariable("id") long id,
                             Model model,
                             final RedirectAttributes redirectAttribute){
        Blog blog = blogService.findBlog(id);
        blogService.deleteBlog(blog);
        redirectAttribute.addFlashAttribute("DELETE_BLOG", "True");
        return "redirect:/admin";
    }

    @GetMapping("/blogs/create")
    public String get(Model model,
                      HttpSession session) {
        User user = (User)session.getAttribute("CURRENT_USER");
        model.addAttribute("blog", new BlogCreateForm());
        model.addAttribute("user", user);
        return "create";
    }

    @PostMapping("/blogs")
    public String post(@ModelAttribute("blog") @Valid BlogCreateForm form,
                       BindingResult result,
                       HttpSession session) {

        if(result.hasErrors()){
            return "create";
        }
        User user = (User)session.getAttribute("CURRENT_USER");
        Blog blog = form.toBlog(user);
        blogService.createBlog(blog);
        return "redirect:/blogs/" + blog.getId();
    }
}
