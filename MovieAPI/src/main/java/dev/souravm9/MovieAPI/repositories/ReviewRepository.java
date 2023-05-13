package dev.souravm9.MovieAPI.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dev.souravm9.MovieAPI.models.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {

}
