package com.example.supergame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
// Maybe needs to be removed, when MongoDB connection is added
public class SuperGameApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuperGameApplication.class, args);
    }

}
