package com.springmvcblog.service;

import java.util.Optional;

import com.springmvcblog.model.Tag;

public interface TagService {
    
    /**
     * 根据标签名获取tag对象
     * @return
     */
    Optional<Tag> findByName(String tag);

}
