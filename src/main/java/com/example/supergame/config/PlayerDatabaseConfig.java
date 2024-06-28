package com.example.supergame.config;

import com.example.supergame.repository.PlayerRepository;
import com.example.supergame.repository.SpellDetailsRepository;
import com.example.supergame.repository.SpellNameRepository;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackageClasses = {PlayerRepository.class, SpellNameRepository.class, SpellDetailsRepository.class})
public class PlayerDatabaseConfig {
    @Bean
    public MongoTemplate mongoTemplate() {
        String connectionString = "mongodb+srv://niklaszimmermann:aKvWTw9c3EttrOfj@supermongo.zjjwzp8.mongodb.net/?retryWrites=true&w=majority&appName=SuperMongo";
        return new MongoTemplate(new SimpleMongoClientDatabaseFactory(MongoClients.create(connectionString), "PlayerDB"));
    }
}
