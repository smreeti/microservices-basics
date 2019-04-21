package com.smriti.MovieCatalogService.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingData {

    private int movieId;

    private int rating;

    public RatingData(){

    }

    public RatingData(int movieId, int rating) {
        this.movieId = movieId;
        this.rating = rating;
    }
}


