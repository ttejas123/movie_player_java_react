package com.example.movie;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    private MoviesRepository moviesRepository;

    public List<Movies> AllMovies() {
        return moviesRepository.findAll();
    }

    public Optional<Movies> singleMovie(String imdbId) {
        return moviesRepository.findMovieByImdbId(imdbId);
    }
}
