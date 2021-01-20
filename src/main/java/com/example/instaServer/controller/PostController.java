package com.example.instaServer.controller;

import com.example.instaServer.model.Post;
import com.example.instaServer.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@CrossOrigin("*")
public class PostController {
    @Autowired
    private PostService service;
    @GetMapping("feed/{id}")
    public List<Post> feed(@PathVariable("id") Long id){
        return this.service.feed(id);
    }

    @GetMapping("all/{id}")
    public List<Post> all(@PathVariable("id") Long id){
        return this.service.posts( id);
    }

    @PostMapping("like/{id}/{c}")
    public void like (@RequestBody Structure st,@PathVariable("id") Long id , @PathVariable("c") Long c){
        System.out.println(st);
        //  System.out.println(new Long(st.c));
        this.service.like(id,c);



    }
  @GetMapping("likes/{id}")public int likes(@PathVariable("id") Long id){
        return this.service.likes(id);  }


@PostMapping("/post/{id}")
        public void post (@RequestBody Post post, @PathVariable("id") Long id)
{

        this.service.post(post,id);
         }






    static class Structure{

        Long id ;Long c ;

        public Structure(Long id,Long c) {
            this.id = id ;
            this.c = c;
        }

        Structure(){
            System.out.println("new Structure");
        }

        @Override
        public String toString() {
            return "Structure{" +
                    "id=" + id +
                    ", c=" + c +
                    '}';
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getC() {
            return c;
        }

        public void setC(Long c) {
            this.c = c;
        }
    }




}
