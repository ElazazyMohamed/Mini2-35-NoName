package com.example.miniapp.services;

import com.example.miniapp.models.Rating;
import com.example.miniapp.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public Rating updateRating(String id, Rating updatedRating) {
        Rating existingRating = ratingRepository.findById(id).orElse(null);
        if (existingRating != null) {
            existingRating.setScore(updatedRating.getScore());
            existingRating.setComment(updatedRating.getComment());
            return ratingRepository.save(existingRating);
        }
        return null;
    }

    public void deleteRating(String id) {
        ratingRepository.deleteById(id);
    }

    public List<Rating> getRatingsByEntity(Long entityId, String entityType) {
        return ratingRepository.findRatingsByEntityIdAndEntityType(entityId, entityType);
    }

    public List<Rating> getRatingsAboveScore(Integer score) {
        return ratingRepository.findRatingsByScoreGreaterThanEqual(score);
    }
}
