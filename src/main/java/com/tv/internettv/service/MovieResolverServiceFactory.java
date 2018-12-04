package com.tv.internettv.service;

import com.tv.internettv.repository.MovieRepository;

class MovieResolverServiceFactory
{
    MovieResolverService create()
    {
        MovieRepository movieRepository = new MovieRepository();
        return new MovieResolverService(movieRepository);
    }
}
