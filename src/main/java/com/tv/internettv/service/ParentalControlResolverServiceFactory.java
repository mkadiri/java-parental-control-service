package com.tv.internettv.service;

import com.tv.internettv.parental_control_service.ParentalControlService;
import com.tv.internettv.thirdparty.MovieService;

public class ParentalControlResolverServiceFactory
{
    public ParentalControlService create()
    {
        MovieService movieResolverService = (new MovieResolverServiceFactory()).create();
        RatingResolverService ratingResolverService = new RatingResolverService();
        return new ParentalControlResolverService(movieResolverService, ratingResolverService);
    }
}
