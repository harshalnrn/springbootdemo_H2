package com.example.springbootdemo.webapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 bootstrappin our application
 with a main(), which delegates all the work to Spring:
 **/


/*@ComponentScan({"com.example.springbootdemo.webapplication.controller","com.example.springbootdemo.webapplication.POJO" })
@EnableJpaRepositories(basePackages = "com.example.springbootdemo.webapplication.repository")
@EntityScan(basePackages = "com.example.springbootdemo.webapplication.repository")*/
@SpringBootApplication
public class SpringbootdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootdemoApplication.class, args);
    }

}

