package com.epam.edu.springbootappconfiguration.repository;

import com.epam.edu.springbootappconfiguration.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
} 