package com.springmvcblog.service.impl;

import com.springmvcblog.model.Blog;
import com.springmvcblog.model.Comment;
import com.springmvcblog.repository.CommentRepository;
import com.springmvcblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment createComment(Comment comment){
        return commentRepository.save(comment);
    }

    /**
     * 更新评论
     * @param comment
     * @return
     */
    @Override
    public Comment updateComment(Comment comment){

        return commentRepository.save(comment);
    }

    /**
     * 删除评论
     * @param comment
     */
    @Override
    public void deleteComment(Comment comment){
        commentRepository.delete(comment);
    }

    @Override
    public List<Comment> getCommentOfBlog(Blog blog){
        Sort sort = new Sort(Sort.Direction.DESC, "createdTime");
        return commentRepository.findAll(blog.getId() ,sort);
    }
}
