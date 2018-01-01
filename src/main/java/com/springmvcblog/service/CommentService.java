package com.springmvcblog.service;

import com.springmvcblog.model.Blog;
import com.springmvcblog.model.Comment;

import java.util.List;

public interface CommentService {

    /**
     * 创建评论
     * @param comment
     * @return
     */
    Comment createComment(Comment comment);

    /**
     * 更新评论
     * @param comment
     * @return
     */
    Comment updateComment(Comment comment);

    /**
     * 删除评论
     * @param comment
     */
    void deleteComment(Comment comment);

    List<Comment> getCommentOfBlog(Blog blog);

}
