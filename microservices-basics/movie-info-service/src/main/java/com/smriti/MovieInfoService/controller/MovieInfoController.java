package com.smriti.MovieInfoService.controller;

import com.smriti.MovieInfoService.entity.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-info")
public class MovieInfoController {

    @RequestMapping("/{movieId}")
    private Movie getMovieInfo(@PathVariable("movieId") Long movieId){
        return new Movie(movieId, "Movie1");
    }
}
