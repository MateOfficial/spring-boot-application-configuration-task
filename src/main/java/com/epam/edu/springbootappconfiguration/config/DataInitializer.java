package com.epam.edu.springbootappconfiguration.config;

import com.epam.edu.springbootappconfiguration.model.Book;
import com.epam.edu.springbootappconfiguration.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DataInitializer {

    @Bean
    @Profile("dev")
    public CommandLineRunner initDevData(@Autowired BookRepository bookRepository) {
        return args -> {
            bookRepository.save(new Book("Spring Boot Essentials", "John Developer", 29.99));
            bookRepository.save(new Book("Mastering Spring Boot", "Jane Coder", 39.99));
            bookRepository.save(new Book("Spring Boot in Action", "Dev Master", 24.99));
        };
    }

    @Bean
    @Profile("test")
    public CommandLineRunner initTestData(@Autowired BookRepository bookRepository) {
        return args -> {
            bookRepository.save(new Book("Test Book 1", "Test Author 1", 19.99));
            bookRepository.save(new Book("Test Book 2", "Test Author 2", 29.99));
        };
    }

    @Bean
    @Profile("prod")
    public CommandLineRunner initProdData(@Autowired BookRepository bookRepository) {
        return args -> {
            bookRepository.save(new Book("Production Ready Spring Boot", "Enterprise Author", 49.99));
            bookRepository.save(new Book("Spring Boot for Production", "Enterprise Dev", 59.99));
            bookRepository.save(new Book("Scaling Spring Boot Apps", "Cloud Expert", 69.99));
            bookRepository.save(new Book("Spring Boot Security", "Security Expert", 54.99));
        };
    }
} 