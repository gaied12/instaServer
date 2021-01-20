package com.example.instaServer;

import com.example.instaServer.model.Post;
import com.example.instaServer.model.User;
import com.example.instaServer.repository.PostRepository;
import com.example.instaServer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class InstaServerApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;

	public static void main(String[] args) {
		SpringApplication.run(InstaServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


	}
}
