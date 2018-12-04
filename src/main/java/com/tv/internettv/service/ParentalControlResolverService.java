package com.tv.internettv.service;

import com.tv.internettv.exception.InvalidMovieControlLevelException;
import com.tv.internettv.parental_control_service.ParentalControlService;
import com.tv.internettv.thirdparty.MovieService;
import com.tv.internettv.thirdparty.TechnicalFailureException;

public class ParentalControlResolverService implements ParentalControlService
{
    private MovieService movieResolverService;
    private RatingResolverService ratingResolver;

    ParentalControlResolverService(MovieService movieResolverService, RatingResolverService ratingResolver)
    {
        this.movieResolverService = movieResolverService;
        this.ratingResolver = ratingResolver;
    }

    public boolean canWatchMovie(String customerParentalControlLevel, String movieId) throws Exception {
        String movieControlLevel = movieResolverService.getParentalControlLevel(movieId);

        try {
            return this.ratingResolver.isControlLevelValid(movieControlLevel, customerParentalControlLevel);

        } catch (InvalidMovieControlLevelException e) {
            throw new TechnicalFailureException();
        }
    }
}
