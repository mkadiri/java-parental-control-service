package com.tv.internettv.entity;

public class MovieEntity {
    private String id;
    private String rating;

    public MovieEntity(String id, String rating) throws IllegalArgumentException{
        if (id.equals("")) {
            throw new IllegalArgumentException("Invalid movie id provided");
        }

        if (rating.equals("")) {
            throw new IllegalArgumentException("Invalid movie rating provided");
        }

        this.id = id;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public String getRating() {
        return rating;
    }
}
