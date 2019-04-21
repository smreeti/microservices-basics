package com.smriti.MovieCatalogService.controller;

import com.smriti.MovieCatalogService.model.Movie;
import com.smriti.MovieCatalogService.model.MovieCatalog;
import com.smriti.MovieCatalogService.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movie-catalog")
public class MovieCatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    private List<MovieCatalog> getMovieList(@PathVariable("userId") Long userId) {

        UserRating ratingData = restTemplate.getForObject("http://ratings-data-service/ratings-data/users/" + userId,
                UserRating.class);

       return ratingData.getRatingData().stream().map(ratings -> {

                    Movie movie = restTemplate.getForObject("http://movie-info-service/movie-info/" + ratings.getMovieId(),
                            Movie.class);

                    return new MovieCatalog(movie.getName(),"test", ratings.getRating());
                }
        ).collect(Collectors.toList());
    }
}
