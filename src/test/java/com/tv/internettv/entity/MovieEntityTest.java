package com.tv.internettv.entity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;

public class MovieEntityTest
{
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void invalidMovie_movieIdTest()
    {
        thrown.expect(IllegalArgumentException.class);
        new MovieEntity("", "PG");
    }

    @Test
    public void invalidMovie_ratingIdTest()
    {
        thrown.expect(IllegalArgumentException.class);
        new MovieEntity("aladdin", "");
    }

    @Test
    public void validMovieTest()
    {
        MovieEntity movie = new MovieEntity("aladdin", "PG");

        assertEquals(movie.getId(), "aladdin");
        assertEquals(movie.getRating(), "PG");
    }
}
