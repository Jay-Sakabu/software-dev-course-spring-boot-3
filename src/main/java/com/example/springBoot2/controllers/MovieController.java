package com.example.springBoot2.controllers;

import com.example.springBoot2.models.Movie;
import com.example.springBoot2.repositories.MovieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // Get all books
    @GetMapping
    public List<Movie> getAllItems() {
        return movieRepository.findAll();
    }

    // Get single movie by ID
    @GetMapping("/{id}")
    public Optional<Movie> getItem(@PathVariable int id) {
        return movieRepository.findById(id);
    }

    // Add movie to repo
    @PostMapping
    public Movie addItem(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    // Update movie
    @PutMapping("/{id}")
    public Movie updateItem(@PathVariable int id, @RequestBody Movie updatedMovie) {
        updatedMovie.setId(id);
        return movieRepository.save(updatedMovie);
    }

    // Delete movie
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id) {
        movieRepository.deleteById(id);
    }


}
