package com.smriti.RatingsDataService.controller;

import com.smriti.RatingsDataService.model.RatingData;
import com.smriti.RatingsDataService.model.UserRatingData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings-data")
public class RatingDataController {

    @GetMapping("/{movieId}")
    private RatingData getMovieRating(@PathVariable("movieId") int movieId) {
        return new RatingData(movieId, 4);
    }

    @GetMapping("/users/{userId}")
    private UserRatingData getUserRatingData(@PathVariable("userId") Long userId) {
        List<RatingData> ratingData = Arrays.asList(
                new RatingData(1234, 5),
                new RatingData(5678, 10)
        );
        UserRatingData userRatingData = new UserRatingData();
        userRatingData.setRatingData(ratingData);
        return userRatingData;
    }
}
