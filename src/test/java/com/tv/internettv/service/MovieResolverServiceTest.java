package com.tv.internettv.service;

import com.tv.internettv.entity.MovieEntity;
import com.tv.internettv.repository.MovieRepository;
import com.tv.internettv.thirdparty.TechnicalFailureException;
import com.tv.internettv.thirdparty.TitleNotFoundException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.Mockito;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

public class MovieResolverServiceTest
{
    @Mock
    MovieRepository movieRepository;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp()
    {
        this.movieRepository = Mockito.mock(MovieRepository.class);
    }

    @Test
    public void getParentalControlLevel_validMovieIdTest() throws TechnicalFailureException, TitleNotFoundException {
        MovieEntity movieEntity = new MovieEntity("speed", "18");

        when(movieRepository.get("speed")).thenReturn(movieEntity);

        MovieResolverService movieResolverService = new MovieResolverService(movieRepository);
        String movieParentalControlLevel = movieResolverService.getParentalControlLevel("speed");

        assertEquals(movieEntity.getRating(), movieParentalControlLevel);
    }

    @Test
    public void getParentalControlLevel_invalidMovieTest() throws TechnicalFailureException, TitleNotFoundException {
        when(movieRepository.get("liveanotherday")).thenThrow(new TechnicalFailureException());

        MovieResolverService movieResolverService = new MovieResolverService(movieRepository);

        thrown.expect(TechnicalFailureException.class);
        movieResolverService.getParentalControlLevel("liveanotherday");
    }

    @Test
    public void getParentalControlLevel_movieNotFoundTest() throws TechnicalFailureException, TitleNotFoundException {
        when(movieRepository.get("liveanotherday")).thenThrow(new TitleNotFoundException());

        MovieResolverService movieResolverService = new MovieResolverService(movieRepository);

        thrown.expect(TitleNotFoundException.class);
        movieResolverService.getParentalControlLevel("liveanotherday");
    }
}