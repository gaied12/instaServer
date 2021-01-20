package com.example.instaServer.repository;

import com.example.instaServer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository  extends JpaRepository<User,Long> {
    Optional<User> getByUnameAndPassword(String username, String password);

    @Query(value = "SELECT * FROM User u WHERE u.name like :status%",
            nativeQuery = true)
    List<User> findUsers(
            @Param("status") String status);


    @Query(value = "SELECT * FROM post_likes u WHERE u.likes_id = :status",
            nativeQuery = true)
    List<Integer> findLikes(
            @Param("status") Long status);
}
