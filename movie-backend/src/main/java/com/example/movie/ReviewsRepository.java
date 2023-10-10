package com.example.movie;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewsRepository extends MongoRepository<Reviews, ObjectId> {
    
}
