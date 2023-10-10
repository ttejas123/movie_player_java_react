package com.example.movie;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MoviesRepository extends MongoRepository<Movies, ObjectId> {
    Optional<Movies> findMovieByImdbId(String imdbId);
}