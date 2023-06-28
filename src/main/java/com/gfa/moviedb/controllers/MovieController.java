package com.gfa.moviedb.controllers;

import com.gfa.moviedb.models.MovieList;
import com.gfa.moviedb.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public MovieList fetchMovies() {
        return movieService.fetchMovies();
    }
}
