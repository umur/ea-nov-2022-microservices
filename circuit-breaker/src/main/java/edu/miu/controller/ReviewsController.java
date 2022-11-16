package edu.miu.controller;

import edu.miu.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {
    @Autowired
    ReviewService reviewService;

    @GetMapping
    public String getReviews() {
        return reviewService.getReview();
    }
}
