package com.gfa.moviedb.services;

import com.gfa.moviedb.models.MovieList;
import org.springframework.stereotype.Service;

@Service
public interface MovieService {
    MovieList fetchMovies();
}
