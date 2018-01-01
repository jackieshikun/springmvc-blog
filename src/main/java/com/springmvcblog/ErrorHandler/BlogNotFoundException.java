package com.springmvcblog.ErrorHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Blog not found")
public class BlogNotFoundException extends RuntimeException{
    public BlogNotFoundException(String message){super(message);}
}
