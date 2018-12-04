package com.tv.internettv.service;

import com.tv.internettv.exception.InvalidCustomerControlLevelException;
import com.tv.internettv.exception.InvalidMovieControlLevelException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;

public class RatingResolverServiceTest
{
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void isControlLevelValid_invalidMovieControlLevelTest() throws InvalidCustomerControlLevelException, InvalidMovieControlLevelException {
        RatingResolverService ratingResolverService = new RatingResolverService();

        thrown.expect(InvalidMovieControlLevelException.class);
        ratingResolverService.isControlLevelValid("BAD_RATING", "U");
    }

    @Test
    public void isControlLevelValid_invalidCustomerControlLevelTest() throws InvalidCustomerControlLevelException, InvalidMovieControlLevelException {
        RatingResolverService ratingResolverService = new RatingResolverService();

        thrown.expect(InvalidCustomerControlLevelException.class);
        ratingResolverService.isControlLevelValid("PG", "BAD_RATING");
    }

    @Test
    public void isControlLevelValid_sameControlLevelTest() throws InvalidCustomerControlLevelException, InvalidMovieControlLevelException {
        RatingResolverService ratingResolverService = new RatingResolverService();

        assertTrue(ratingResolverService.isControlLevelValid("PG", "PG"));
    }

    @Test
    public void isControlLevelValid_customerControlLevelGreaterTest() throws InvalidCustomerControlLevelException, InvalidMovieControlLevelException {
        RatingResolverService ratingResolverService = new RatingResolverService();

        assertTrue(ratingResolverService.isControlLevelValid("PG", "18"));
    }

    @Test
    public void isControlLevelValid_customerControlLevelLesserTest() throws InvalidCustomerControlLevelException, InvalidMovieControlLevelException {
        RatingResolverService ratingResolverService = new RatingResolverService();

        assertFalse(ratingResolverService.isControlLevelValid("18", "PG"));
    }
}
