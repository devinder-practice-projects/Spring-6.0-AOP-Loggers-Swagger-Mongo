package com.example.Spring_6.__AOP_Loggers_Swagger_Mongo.repo;

import com.example.Spring_6.__AOP_Loggers_Swagger_Mongo.model.JobPost;

import java.util.List;

public interface SearchRepo {
    List<JobPost> findByText(String text);
}
