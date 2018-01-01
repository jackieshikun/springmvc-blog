package com.springmvcblog.form;

import org.hibernate.validator.constraints.Email;
import javax.validation.constraints.Size;

public class UserModifyForm {
    @Size(min = 1, max = 10, message = "Username required length between 1 and 10")
    private String name;
    @Email
    private String email;
    @Size(min = 0, max = 10, message = "Password required length between 1 and 10")
    private String password;
    @Size(min = 0, max = 255, message = "Intro's length cannot exceed 255")
    private String intro;

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
}
