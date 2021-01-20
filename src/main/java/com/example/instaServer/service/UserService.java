package com.example.instaServer.service;

import com.example.instaServer.model.User;
import com.example.instaServer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;
    public User login(String username , String password)
    {
        Optional<User> current = this.userRepo.getByUnameAndPassword(username,password);
        if (current.isPresent() ) {
            System.out.println("valid");


            return current.get();


        }

        else {
            System.out.println("invalid");return null;}


    }




   public List<User> findUsers(String status)
    { return  this.userRepo.findUsers(status);}


   public List<Integer>findLikes(Long id)
    {return this.userRepo.findLikes(id);}








}
