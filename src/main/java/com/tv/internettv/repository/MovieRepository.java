package com.tv.internettv.repository;

import com.tv.internettv.entity.MovieEntity;
import com.tv.internettv.thirdparty.TechnicalFailureException;
import com.tv.internettv.thirdparty.TitleNotFoundException;

public class MovieRepository
{
    /**
     * Finds and returns a movie based on a movie id
     *
     * If there is a problem creating movie entities it won't be due to user input and a TechnicalFailureException
     * should be thrown
     *
     * @param movieId
     * @return
     * @throws TitleNotFoundException
     * @throws TechnicalFailureException
     */
    public MovieEntity get(String movieId) throws TitleNotFoundException, TechnicalFailureException {
        for (MovieEntity movie : this.getMockMovies()) {
            if (movie.getId().equals(movieId)) {
                return movie;
            }
        }

        throw new TitleNotFoundException();
    }

    private MovieEntity[] getMockMovies() throws TechnicalFailureException {
        try{
            return new MovieEntity[]{
                new MovieEntity("aladdin", "PG"),
                new MovieEntity("space", "12"),
                new MovieEntity("jumanji", "U"),
                new MovieEntity("horrorhouse", "15"),
                new MovieEntity("homealone", "18")
            };

        } catch (IllegalArgumentException e) {
            throw new TechnicalFailureException();
        }
    }
}
