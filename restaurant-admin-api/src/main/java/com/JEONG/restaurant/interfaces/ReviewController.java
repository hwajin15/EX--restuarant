package com.JEONG.restaurant.interfaces;

import com.JEONG.restaurant.application.ReviewService;
import com.JEONG.restaurant.domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews") //전체 리뷰 관리
    public List<Review> list(){
        List<Review > reviews =reviewService.getReviews();
        return reviews;
    }

}
