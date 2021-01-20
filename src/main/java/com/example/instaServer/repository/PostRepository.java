package com.example.instaServer.repository;

import com.example.instaServer.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository  extends JpaRepository<Post,Long> {

    @Query(value ="select * from post  order by  date",nativeQuery = true)
    List<Post> getPosts();
    @Query(value ="select post_id from post_likes",nativeQuery = true)
    List<Integer> getLikesCount();


}
