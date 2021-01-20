package com.example.instaServer.controller;


import com.example.instaServer.model.User;
import com.example.instaServer.repository.UserRepository;
import com.example.instaServer.service.PostService;
import com.example.instaServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private UserService userService;
    @Autowired
    private PostService service;
    @GetMapping("/all")
    public List<User> getAll ()
    {

        return this.userRepo.findAll();
    }

    @GetMapping("findLikes/{id}")
    public List<Integer>findLikes(@PathVariable("id")Long id){return this.userService.findLikes(id);

    }
    @RequestMapping("/one")
    User getCurrent(@RequestParam (name="id") Long id){
        return this.userRepo.findById(id).get();
    }

    @PostMapping("/login")
    public User login(@RequestBody Coord coord)
    {
        System.out.println(coord);

        return this.userService.login(coord.username , coord.password)  ;
    }



  @GetMapping("filter/{like}")List<User>getUsers(@PathVariable ("like")String status){
        return this.userService.findUsers(status);
  }



    static class Coord{
        String username;
        String password;

        public Coord(String username, String password) {
            this.username = username;
            this.password = password;
        }

        @Override
        public String toString() {
            return "Coord{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }












}
