package com.springmvcblog.controller;

import com.springmvcblog.model.User;
import com.springmvcblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.Optional;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping
    public String get(@RequestParam(value = "next", required = false) Optional<String> next
            ,Model model,
                      HttpSession session) {
        //System.out.println("next is " + next.get());
        if(next.isPresent())
            model.addAttribute("next", next.get());
        User user = (User)session.getAttribute("CURRENT_USER");

        if(user != null){
            return "redirect:/" + user.getName();
        }

        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping
    public String post(@RequestParam(value = "next", required = false) Optional<String> next
            ,User user,
                       Model model,
                       HttpSession session) {
        User realUser = userService.login(user.getEmail(), user.getPassword());
        //System.out.println(next);
        session.removeAttribute("NEXT");
        if(realUser == null){
            model.addAttribute("error","Email or username is wrong");
            if(!next.isPresent())
                return "login";
            return "redirect:/login?next=" + next.get();
        }
        session.setAttribute("CURRENT_USER", realUser);
        //System.out.println(next.get());
        if(!next.isPresent())
            return "redirect:/" + realUser.getName();
        return "redirect:" + next.get();
    }

}