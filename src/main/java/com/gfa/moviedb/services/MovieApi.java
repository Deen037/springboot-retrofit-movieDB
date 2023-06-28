package com.gfa.moviedb.services;

import com.gfa.moviedb.models.MovieList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieApi {

    @GET("/3/movie/changes")
    Call<MovieList> fetchMovies();
}
