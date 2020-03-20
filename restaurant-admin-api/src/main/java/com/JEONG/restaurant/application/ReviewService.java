package com.JEONG.restaurant.application;

import com.JEONG.restaurant.domain.Review;
import com.JEONG.restaurant.domain.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    public List<Review> getReviews() {
        return reviewRepository.findAll();

    }
}
