package com.springmvcblog.model;


public class Tag {

    private String name;

    public Tag() {
        super();
    }

    public Tag(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if( getName().equals(((Tag) obj).getName()) ){
            return true;
        }else{
            return false;
        }
    }
}
