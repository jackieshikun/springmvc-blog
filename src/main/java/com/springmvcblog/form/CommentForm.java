package com.springmvcblog.form;

import com.springmvcblog.model.Blog;
import com.springmvcblog.model.Comment;
import com.springmvcblog.model.User;

import javax.validation.constraints.Size;
import java.util.Date;

public class CommentForm {
    @Size(min = 1, message="Comment cannot be empty")
    private String content;

    private long commentId;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    private Blog blog;
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Comment toComment(){
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setCreatedTime(new Date());
        comment.setId(commentId);
        comment.setBlog(blog);
        comment.setCommentor(user);
        return comment;
    }
}
