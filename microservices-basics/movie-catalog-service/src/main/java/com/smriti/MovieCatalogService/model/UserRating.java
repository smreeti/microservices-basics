package com.smriti.MovieCatalogService.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserRating {

    private List<RatingData> ratingData;

    public UserRating(){

    }
}
