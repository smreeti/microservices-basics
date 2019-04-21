package com.smriti.MovieCatalogService.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieCatalog {

    private String name;

    private String description;

    private Integer rating;

    public MovieCatalog(String name, String description, Integer rating) {
        this.name = name;
        this.description = description;
        this.rating = rating;
    }
}
