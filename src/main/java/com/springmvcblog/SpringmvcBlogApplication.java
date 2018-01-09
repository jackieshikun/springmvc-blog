package com.springmvcblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;



@SpringBootApplication
@ServletComponentScan
public class SpringmvcBlogApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(SpringmvcBlogApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringmvcBlogApplication.class, args);
	}
}