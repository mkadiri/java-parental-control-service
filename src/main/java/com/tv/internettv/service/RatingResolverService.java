package com.tv.internettv.service;

import com.tv.internettv.exception.InvalidCustomerControlLevelException;
import com.tv.internettv.exception.InvalidMovieControlLevelException;

import java.util.HashMap;

public class RatingResolverService
{
    public static final HashMap<String, Integer> ratings = new HashMap<String, Integer>();

    static {
        ratings.put("U", 0);
        ratings.put("PG", 1);
        ratings.put("12", 2);
        ratings.put("15", 3);
        ratings.put("18", 4);
    }

    boolean isControlLevelValid(String movieControlLevel, String customerControlLevel) throws InvalidMovieControlLevelException, InvalidCustomerControlLevelException {
        Integer movieRating = ratings.get(movieControlLevel);
        Integer customerRating = ratings.get(customerControlLevel);

        if (movieRating == null) {
            throw new InvalidMovieControlLevelException();
        }

        if (customerRating == null) {
            throw new InvalidCustomerControlLevelException();
        }

        return movieRating <= customerRating;
    }
}
