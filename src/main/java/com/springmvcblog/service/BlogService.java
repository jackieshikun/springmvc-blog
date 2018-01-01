package com.springmvcblog.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springmvcblog.model.Blog;
import com.springmvcblog.model.User;

public interface BlogService {

    /**
     * 创建博客
     * @param blog
     */
    Blog createBlog(Blog blog);

    /**
     * 根据id获取博客
     * @param id
     * @return
     */
    Blog findBlog(long id);

    /**
     * 更新博客信息
     * @param blog
     * @return
     */
    Blog updateBlog(Blog blog);

    /**
     * 删除博客
     * @param blog
     */
    void deleteBlog(Blog blog);

    /**
     * 获取所有博客
     * @return
     */
    List<Blog> findBlogs();

    /**
     * 获取某个作者的所有博客
     * @param user
     * @return
     */
    List<Blog> findBlogs(User user);

    /**
     * 获取邮箱对应用户创建的所有博客
     * @param tag
     * @return
     */
    List<Blog> findBlogs(String email);

    /**
     * 获取某个用户某段时间内创建的所有博客
     * @param user
     * @param startDate
     * @param endDate
     * @return
     */
    List<Blog> findBlogs(User user, Date startDate, Date endDate);

    /**
     * 分页获取所有博客
     * @param user
     * @return
     */
    Page<Blog> findBlogs(Pageable pageable);

    /**
     * 分页获取某个作者的所有博客
     * @param user
     * @return
     */
    Page<Blog> findBlogs(User user, Pageable pageable);

    /**
     * 根据标签分页获取博客列表
     * @param tag
     * @param pageable
     * @return
     */
    Page<Blog> findBlogsByTag(String tag, Pageable pageable);

    /**
     * 根据标签获取博客列表
     * @param tag
     * @return
     */
    List<Blog> findBlogsByTag(String tag);

    List<Blog> findBlogsByKey(String key);

}
