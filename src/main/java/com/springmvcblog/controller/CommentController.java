package com.springmvcblog.controller;

import com.springmvcblog.form.CommentForm;
import com.springmvcblog.model.Blog;
import com.springmvcblog.model.User;
import com.springmvcblog.service.BlogService;
import com.springmvcblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;

    @PostMapping("/blogs/{id}/comments")
    public String addComment(@PathVariable("id") long id,
                             @ModelAttribute("Comment") CommentForm commentForm,
                             HttpSession session){
        if(session.getAttribute("CURRENT_USER") == null){
            return "redirect:/login?next=/blogs/" + id;
        }
        Blog blog = blogService.findBlog(id);
        commentForm.setBlog(blog);
        commentForm.setUser((User)session.getAttribute("CURRENT_USER"));
        commentService.createComment(commentForm.toComment());
        return "redirect:/blogs/" + id;

    }
}
