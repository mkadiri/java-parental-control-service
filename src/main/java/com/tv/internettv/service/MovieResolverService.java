package com.tv.internettv.service;

import com.tv.internettv.entity.MovieEntity;
import com.tv.internettv.repository.MovieRepository;
import com.tv.internettv.thirdparty.MovieService;
import com.tv.internettv.thirdparty.TechnicalFailureException;
import com.tv.internettv.thirdparty.TitleNotFoundException;

public class MovieResolverService implements MovieService
{
    private MovieRepository movieRepository;

    MovieResolverService(MovieRepository movieRepository)
    {
        this.movieRepository = movieRepository;
    }

    public String getParentalControlLevel(String movieId) throws TitleNotFoundException, TechnicalFailureException {

        MovieEntity movie = this.movieRepository.get(movieId);
        return movie.getRating();
    }
}
