package com.springmvcblog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BlogMetaInfo {

    private Long id;

    @JsonIgnore
    private User user;

    private String title;
    private String description;
    private String backgroundImage;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null){
            return false;
        }
        if (!getClass().equals(obj.getClass()) ) {
            return false;
        }
        if( getId().equals(((BlogMetaInfo) obj).getId()) ){
            return true;
        }else{
            return false;
        }
    }

}
