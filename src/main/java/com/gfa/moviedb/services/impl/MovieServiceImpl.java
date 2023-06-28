package com.gfa.moviedb.services.impl;

import com.gfa.moviedb.models.MovieList;
import com.gfa.moviedb.services.MovieApi;
import com.gfa.moviedb.services.MovieService;
import com.gfa.moviedb.util.RetrofitUtil;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

@Component
public class MovieServiceImpl implements MovieService {

    private final MovieApi movieApi;

    public MovieServiceImpl() {
        Retrofit retrofit = RetrofitUtil.getClient();
        movieApi = retrofit.create(MovieApi.class);
    }


    @Override
    public MovieList fetchMovies() {
        MovieList moviesResponse = new MovieList();

        Call<MovieList> fetchMoviesCall = movieApi.fetchMovies();

        try {
            Response<MovieList> response = fetchMoviesCall.execute();
            if (response.isSuccessful() && response.body() != null) {
                moviesResponse =  response.body();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return moviesResponse;
    }

}
