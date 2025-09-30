package com.example.Spring_6.__AOP_Loggers_Swagger_Mongo.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "job-post")
@Data
public class JobPost {

    private String profile;
    private String desc;
    private int experience;
    private String tech[];

}
