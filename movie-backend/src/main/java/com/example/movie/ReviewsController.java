package com.example.movie;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewsController {
    @Autowired
    ReviewsService reviewsService;

    @GetMapping
    public ResponseEntity<List<Reviews>> getMovies(){
        return new ResponseEntity<List<Reviews>>(reviewsService.allReviews(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Reviews> createReviews(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Reviews>(reviewsService.createReviews(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.CREATED);
    }
}
