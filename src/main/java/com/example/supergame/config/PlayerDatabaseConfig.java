package com.example.supergame.config;

import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.supergame.repository.player")
public class PlayerDatabaseConfig {

    @Primary
    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(new SimpleMongoClientDatabaseFactory(MongoClients.create("mongodb+srv://niklaszimmermann:aKvWTw9c3EttrOfj@supermongo.zjjwzp8.mongodb.net/?retryWrites=true&w=majority&appName=SuperMongo"), "PlayerDB"));
    }
}
