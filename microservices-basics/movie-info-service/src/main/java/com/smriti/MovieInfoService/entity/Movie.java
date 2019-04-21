package com.smriti.MovieInfoService.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie {

    private Long movieId;

    private String name;

    public Movie(Long movieId, String name) {
        this.movieId = movieId;
        this.name = name;
    }
}
