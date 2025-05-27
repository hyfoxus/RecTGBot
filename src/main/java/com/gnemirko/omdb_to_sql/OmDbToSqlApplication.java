package com.gnemirko.omdb_to_sql;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OmDbToSqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(OmDbToSqlApplication.class, args);
    }
    @Bean
    public CommandLineRunner debugBeans(ApplicationContext context) {
        return args -> {
            System.out.println("ChatClient exists: " + context.containsBeanDefinition("chatClient"));
        };
    }


}

