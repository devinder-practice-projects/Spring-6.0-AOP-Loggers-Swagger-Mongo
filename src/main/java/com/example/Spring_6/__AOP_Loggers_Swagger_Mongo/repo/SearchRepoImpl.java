package com.example.Spring_6.__AOP_Loggers_Swagger_Mongo.repo;

import com.example.Spring_6.__AOP_Loggers_Swagger_Mongo.model.JobPost;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepoImpl implements SearchRepo{

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter converter;

    @Override
    public List<JobPost> findByText(String searchedText) {
        List<JobPost> posts = new ArrayList<>();
        MongoDatabase database = mongoClient.getDatabase("dev-mongo");
        MongoCollection<Document> collection = database.getCollection("job-post");
        AggregateIterable<Document> result = collection
                .aggregate(Arrays.asList
                                (new Document("$search",
                                        new Document("index", "default")
                                        .append("text",
                                                new Document("query", searchedText).append("path", Arrays.asList("tech", "experience", "profile"))
                                               )
                                              ),
                                new Document("$sort", new Document("experience", 1L)),
                                new Document("$limit", 2L)
                                )
                );

        result.forEach(doc -> posts.add(converter.read(JobPost.class, doc)));
        return posts;
    }
}
