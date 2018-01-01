package com.springmvcblog.service;

import com.springmvcblog.model.BlogMetaInfo;
import com.springmvcblog.model.User;

public interface BlogMetaInfoService {
    
    /**
     * 为用户初始化BlogMetaInfo
     * @param user
     * @return
     */
    BlogMetaInfo initBlogMetaInfo(User user);
    
    /**
     * 更新BlogMetaInfo
     * @param blogMetaInfo
     * @return
     */
    BlogMetaInfo updateBlogMetaInfo(BlogMetaInfo blogMetaInfo);

}
