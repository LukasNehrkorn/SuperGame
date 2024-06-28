package com.example.supergame.config;

import com.example.supergame.repository.*;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackageClasses = {WeaponsRepository.class, ConsumablesRepository.class})
public class ItemsDatabaseConfig {

    protected String getDatabaseName() {
        return "ItemsDB";
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        String connectionString = "mongodb+srv://niklaszimmermann:aKvWTw9c3EttrOfj@supermongo.zjjwzp8.mongodb.net/?retryWrites=true&w=majority&appName=SuperMongo";
        return new MongoTemplate(new SimpleMongoClientDatabaseFactory(MongoClients.create(connectionString), "ItemsDB"));
    }
}
