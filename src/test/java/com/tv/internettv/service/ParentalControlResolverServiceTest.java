package com.tv.internettv.service;

import com.tv.internettv.parental_control_service.ParentalControlService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.when;

public class ParentalControlResolverServiceTest {
    @Mock
    public MovieResolverService movieResolverService;

    @Mock
    public RatingResolverService ratingResolverService;

    @Before
    public void setUp()
    {
        this.movieResolverService = Mockito.mock(MovieResolverService.class);
        this.ratingResolverService = Mockito.mock(RatingResolverService.class);
    }

    /**
     * I realised that it wasn't worth testing this method as it just aggregates service classes and returns
     * a value returned by the RatingResolver class
     */
    @Test
    public void canWatchMovie_test() throws Exception {
        String customerControlLevel = "18";
        String movieControlLevel = "PG";
        String movieId = "aladdin";

        ParentalControlService parentalControlService = new ParentalControlResolverService(this.movieResolverService,
                this.ratingResolverService);

        when(movieResolverService.getParentalControlLevel(movieId)).thenReturn(movieControlLevel);
        when(ratingResolverService.isControlLevelValid(movieControlLevel, customerControlLevel)).thenReturn(true);

        assertTrue(parentalControlService.canWatchMovie(customerControlLevel, movieId));
    }
}
