package com.springmvcblog.controller;

import com.springmvcblog.form.UserRegisterForm;
import com.springmvcblog.model.User;
import com.springmvcblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String get(Model model) {
        model.addAttribute("user", new UserRegisterForm());
        return "register";
    }

    @PostMapping
    public String post(@ModelAttribute("user") @Valid UserRegisterForm userRegisterForm,
                       BindingResult result,
                       HttpSession session,
                       final RedirectAttributes redirectAttributes,
                       Model model) {
        //Your code goes here
        if(result.hasErrors()){
            return "register";
        }
        User user = userRegisterForm.toUser();
        if(userService.findByEmail(user.getEmail()) != null){
            model.addAttribute("message", "Email is already registered, please try another one");
            return "register";
        }
        userService.register(user);
        session.setAttribute("CURRENT_USER", user);
        redirectAttributes.addFlashAttribute("message", "user created");
        return "redirect:/admin";
    }

}
