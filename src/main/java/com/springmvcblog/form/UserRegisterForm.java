package com.springmvcblog.form;

import com.springmvcblog.model.User;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Size;

public class UserRegisterForm {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Size(min = 6, max = 30, message="Username required length between 6 and 30")
    private String name;

    @Size(min = 6, max = 30, message = "Password required length between 6 and 30")
    private String password;

    @Email
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User toUser(){
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        return user;
    }



}
