package com.tv.internettv.thirdparty;

public interface MovieService {
        String getParentalControlLevel(String titleId) throws TitleNotFoundException, TechnicalFailureException;
}
