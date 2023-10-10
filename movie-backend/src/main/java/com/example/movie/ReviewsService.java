package com.example.movie;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewsService {
    @Autowired
    ReviewsRepository reviewsRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Reviews> allReviews() {
        return reviewsRepository.findAll();
    }

    public Reviews createReviews(String reviewBody, String imdbId) {
        Reviews newReviews =reviewsRepository.insert(new Reviews(reviewBody));

        mongoTemplate.update(Movies.class)
            .matching(Criteria.where("imdbId").is(imdbId))
            .apply(new Update().push("reviewsIds").value(newReviews))
            .first();

        return newReviews;
    }
}
