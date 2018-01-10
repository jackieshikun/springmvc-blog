package com.springmvcblog.controller;

import com.springmvcblog.ErrorHandler.UserNotFoundException;
import com.springmvcblog.form.UserModifyForm;
import com.springmvcblog.model.User;
import com.springmvcblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class ProfileController {

    private static String ROOT;
    @Autowired
    public void rootPath(@Value("${file.dir}") String root){
        ROOT = root;
    }

    @Autowired
    private UserService userService;

    private final ResourceLoader resourceLoader;

    @Autowired
    public ProfileController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @GetMapping(value="/profile")
    public String getProfile(HttpSession session,
                             Model model,
                             @ModelAttribute("update_succ") String message){

        User currentUser = (User)session.getAttribute("CURRENT_USER");
        UserModifyForm modifyForm = new UserModifyForm();
        modifyForm.setIntro(currentUser.getIntro());
        modifyForm.setName(currentUser.getName());
        model.addAttribute("user", modifyForm);
        return "profile";
    }

    @PostMapping(value="/profile")
    public String updateProfile(@RequestParam(value = "file", required = false) MultipartFile file,
                                @Valid @ModelAttribute("user") UserModifyForm user,
                                BindingResult result,
                                HttpSession session,
                                Model model,
                                final RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "profile";
        }

        User newUser = (User)session.getAttribute("CURRENT_USER");
        boolean isModified = false;
        if(user.getName().length() > 0 && !newUser.getName().equals(user.getName())){
            isModified = true;
            newUser.setName(user.getName());
        }

        if(user.getIntro().length() > 0 &&
                (newUser.getIntro() == null || !newUser.getIntro().equals(user.getIntro()) )
                ){
            isModified = true;
            newUser.setIntro(user.getIntro());

        }

        if(user.getPassword().length() > 0 && !newUser.getPassword().equals(user.getPassword())){
            isModified = true;
            newUser.setPassword(user.getPassword());
        }
        if(file != null && file.isEmpty() == false){
            isModified = true;
            String filename = newUser.getId() + ".jpg";
            try{
                Files.copy(file.getInputStream(), Paths.get(ROOT, filename));
            }catch(IOException e){
                throw new UserNotFoundException("avatar upload failed");
            }
        }

        if(isModified){
            userService.update(newUser);
            System.out.println("User intro:" + newUser.getIntro());
            session.setAttribute("CURRENT_USER", newUser);
            redirectAttributes.addFlashAttribute("update_succ",true);
        }
        return "redirect:/profile";
    }

    @GetMapping(value="/avatar/{username}")
    @ResponseBody
    public ResponseEntity<?> getImage(@PathVariable("username") String username,
                                      HttpSession session){
        User user = userService.findByName(username);
        Resource res = resourceLoader.getResource("file:" + Paths.get(ROOT, user.getId()+".jpg").toString());
        //System.out.println(Paths.get(ROOT, "catty.jpeg").toString());
        if(res.exists() == false){
            res = resourceLoader.getResource("file:" + Paths.get(ROOT, "catty.jpeg").toString());
        }
        try{
            return ResponseEntity.ok(res);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

}