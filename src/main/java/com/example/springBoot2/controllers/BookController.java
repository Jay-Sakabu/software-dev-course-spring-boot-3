package com.example.springBoot2.controllers;

import com.example.springBoot2.models.Book;
import com.example.springBoot2.repositories.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Get all books
    @GetMapping
    public List<Book> getAllItems() {
        return bookRepository.findAll();
    }

    // Get single book by ID
    @GetMapping("/{id}")
    public Optional<Book> getItem(@PathVariable int id) {
        return bookRepository.findById(id);
    }

    // Add book to repo
    @PostMapping
    public Book addItem(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    // Update book
    @PutMapping("/{id}")
    public Book updateItem(@PathVariable int id, @RequestBody Book updatedBook) {
        updatedBook.setId(id);
        return bookRepository.save(updatedBook);
    }

    // Delete book
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id) {
        bookRepository.deleteById(id);
    }
}