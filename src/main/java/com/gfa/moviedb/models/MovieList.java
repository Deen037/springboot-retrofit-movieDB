package com.gfa.moviedb.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieList {

    public List<Movie> results;

    public int page;
    public int total_pages;
    public int total_results;

}
