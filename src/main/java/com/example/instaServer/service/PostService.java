package com.example.instaServer.service;

import com.example.instaServer.model.Post;
import com.example.instaServer.model.User;
import com.example.instaServer.repository.PostRepository;
import com.example.instaServer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepo;
    @Autowired
    private UserRepository userRepo;


    public void like(Long id , Long c){
        System.out.println("from like  in service");
        User cu=this.userRepo.findById(c).get();
        Post cp=this.postRepo.findById(id).get();
        cp.add(cu);
        System.out.println("///////////////////");
        System.out.println(cp);
        this.postRepo.save(cp);




    }

    public List<Post> feed(Long id)
    {User user = userRepo.findById(id).get();
        List <Post> lsff = new ArrayList<>();
        List<Post> ls = new ArrayList<>();
        List <Post> lsf=postRepo.getPosts();
        List <User> followers=user.getFollowrs();
        for(User u :followers)
        {for(Post p : u.getPosts()){
            ls.add(p);
        }


        }


        for (Post p:lsf){
            if( ls.contains(p))
            {lsff.add(p);}
        }


        for(Post p : lsff ){
            System.out.println(p);
        }




        return lsff ;
    }





    public List<Post> posts(Long id){
        return this.userRepo.findById(id).get().getPosts();

    }










public int likes(Long id)
{int c=0;for (Integer i :this.postRepo.getLikesCount())

{if(i==id.intValue());c++;}
return c;
}




public void post(Post post ,Long id){

        User user =this.userRepo.findById(id).get();
        post.setUser(user);this.postRepo.save(post);


}








}

