package com.example.Spring_6.__AOP_Loggers_Swagger_Mongo.aop;

import com.example.Spring_6.__AOP_Loggers_Swagger_Mongo.controller.JobPostController;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    //@Before is executing before
    @Before("execution(public * com.example.Spring_6.__AOP_Loggers_Swagger_Mongo.controller.JobPostController.getAllPosts())")
    public void beforeLog(){
        LOGGER.info("Entered in JobPostController Class, getAllPosts() method, Called from Aspect ");
    }

    //@After is @After(finally) which means where exception occur or not, this will definitely execute.
    @After("execution(public * com.example.Spring_6.__AOP_Loggers_Swagger_Mongo.controller.JobPostController.getAllPosts())")
    public void afterLog(){
        LOGGER.info("JobPostController Class, getAllPosts() method, After Finally Log Called from Aspect ");
    }


    //@AfterReturning will execute only when a method successfully returns.
    @AfterReturning("execution(public * com.example.Spring_6.__AOP_Loggers_Swagger_Mongo.controller.JobPostController.getAllPosts())")
    public void afterReturningLog(){
        LOGGER.info("JobPostController Class, getAllPosts() method, After Returning Log Called from Aspect ");
    }

    //@AfterThrowing will execute only when an exception is thrown by method.
    @AfterThrowing("execution(public * com.example.Spring_6.__AOP_Loggers_Swagger_Mongo.controller.JobPostController.getAllPosts())")
    public void afterThrowingLog(){
        LOGGER.info("JobPostController Class, getAllPosts() method, After Throwing Log Called from Aspect ");
    }

}
