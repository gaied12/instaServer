package com.example.instaServer.model;

import javax.persistence.*;
import java.util.List;


@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String uname;
    private String password;
    private String img ;


   @OneToMany (fetch = FetchType.LAZY)
    List<User> followrs;

    @OneToMany(mappedBy="user",fetch = FetchType.LAZY)
    List<Post> posts ;
public User(){}
    public User(String name, String uname, String password, String img) {
        this.name = name;
        this.uname = uname;
        this.password = password;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImg() {
        return img;
    }

    public Long getId() {
        return id;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<User> getFollowrs() {
        return followrs;
    }

    public void setFollowrs(List<User> followrs) {
        this.followrs = followrs;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }


/*
    public void add(User user){
        if (this.likes==null){
            likes= new ArrayList<User>();
            likes.add(user);
        }
        this.likes.add(user);

    }*/







}
