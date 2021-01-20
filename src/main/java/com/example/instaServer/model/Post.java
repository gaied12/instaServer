package com.example.instaServer.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Post {


    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String img;
    private String description;
    private LocalDateTime date = LocalDateTime.now();
    private boolean liked ;

@ManyToOne
    private User user;
   @OneToMany (fetch = FetchType.LAZY)
    private List<User> likes;
    public Post(){}

    public Post(String name, String img, String description, User user) {
        this.name = name;
        this.img = img;
        this.description = description;
        this.user = user;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public void setUser(User user) {
        this.user = user;
    }

    public void setLikes(List<User> likes) {
        this.likes = likes;
    }


    public void add(User user){
        if (this.likes==null){
            likes= new ArrayList<User>();
            likes.add(user);
        }
        this.likes.add(user);

    }








}
