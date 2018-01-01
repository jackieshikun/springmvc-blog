package com.springmvcblog.form;

import com.springmvcblog.model.Blog;
import com.springmvcblog.model.User;

import javax.validation.constraints.Size;
import java.util.Date;

public class BlogCreateForm {

    @Size(min = 1, max = 255, message = "Title required length between 1 and 255")
    private String title;

    @Size(min = 1, message = "content cannot be empty")
    private String content;

    @Size(min = 1, max = 255, message = "Summary required length between 1 and 255")
    private String summary;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Blog toBlog(User author) {
        Blog blog = new Blog();
        blog.setTitle(this.title);
        blog.setContent(this.content);
        blog.setCreatedTime(new Date());
        blog.setAuthor(author);
        blog.setSummary(summary);
        return blog;
    }
}
