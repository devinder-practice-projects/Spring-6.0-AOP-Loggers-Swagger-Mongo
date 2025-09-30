package com.example.Spring_6.__AOP_Loggers_Swagger_Mongo.repo;

import com.example.Spring_6.__AOP_Loggers_Swagger_Mongo.model.JobPost;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface PostRepository extends MongoRepository<JobPost, String> {
}
