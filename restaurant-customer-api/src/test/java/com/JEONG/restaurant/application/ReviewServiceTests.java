package com.JEONG.restaurant.application;

import com.JEONG.restaurant.domain.Review;
import com.JEONG.restaurant.domain.ReviewRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class ReviewServiceTests {

    private ReviewService reviewService;
    @Mock
    private ReviewRepository reviewRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        reviewService = new ReviewService(reviewRepository);
    }
    @Test
    public void addReview(){
        Review review = Review.builder()
                .name("JOKER")
                .score(3)
                .description("Mat-it-da")
                .build();

        reviewService.addReview(1004L,review);
        verify(reviewRepository).save(any());

    }

}