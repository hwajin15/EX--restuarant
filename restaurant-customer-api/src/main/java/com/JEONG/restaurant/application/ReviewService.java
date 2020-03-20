package com.JEONG.restaurant.application;

import com.JEONG.restaurant.domain.Review;
import com.JEONG.restaurant.domain.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review addReview(Long restaurantId ,Review review) {

        //서비스 연결
        review.setRestaurantId(restaurantId);
        return reviewRepository.save(review);
    }
}
