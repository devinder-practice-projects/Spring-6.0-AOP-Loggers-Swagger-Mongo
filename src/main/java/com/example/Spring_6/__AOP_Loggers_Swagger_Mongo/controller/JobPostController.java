package com.example.Spring_6.__AOP_Loggers_Swagger_Mongo.controller;

import com.example.Spring_6.__AOP_Loggers_Swagger_Mongo.model.JobPost;
import com.example.Spring_6.__AOP_Loggers_Swagger_Mongo.repo.PostRepository;
import com.example.Spring_6.__AOP_Loggers_Swagger_Mongo.repo.SearchRepo;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class JobPostController {

    @Autowired
    PostRepository postRepo;

    @Autowired
    SearchRepo searchRepo;

    @Hidden    //@Hidden is used in spring doc open api is used for preventing default swagger api to display
    @GetMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException{
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping(value = "/posts")
    public List<JobPost> getAllPosts(){
        return postRepo.findAll();
    }

    @PostMapping(value = "/post")
    public JobPost addPost(@RequestBody JobPost jobPost){
        return postRepo.save(jobPost);
    }

    @GetMapping(value="/post/{text}")
    public List<JobPost> search(@PathVariable("text") String text){
        return searchRepo.findByText(text);
    }

}
