package com.tv.internettv;

import com.tv.internettv.exception.InvalidCustomerControlLevelException;
import com.tv.internettv.service.ParentalControlResolverServiceFactory;
import com.tv.internettv.thirdparty.TechnicalFailureException;
import com.tv.internettv.thirdparty.TitleNotFoundException;

import java.util.Scanner;

public class ClientApplication {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Available movies:\n" +
                "[movie-id: aladdin] - [movie-rating: PG]\n" +
                "[movie-id: space] - [movie-rating: 12]\n" +
                "[movie-id: jumanji] - [movie-rating: U]\n" +
                "[movie-id: horrorhouse] - [movie-rating: 15]\n" +
                "[movie-id: homealone] - [movie-rating: 18]\n");

        System.out.println("Enter a parental control level: ");
        String level = scan.next();

        System.out.println("Enter a movie id: ");
        String moveId = scan.next();

        try {
            boolean canWatchMovie = (new ParentalControlResolverServiceFactory()).create().canWatchMovie(level, moveId);
            System.out.println(canWatchMovie);

        } catch (TitleNotFoundException e) {
            System.out.println("Could not find movie with the id: [" + moveId + "]");

        } catch (InvalidCustomerControlLevelException e) {
            System.out.println("Invalid movie control level: [" + level + "]");

        } catch (TechnicalFailureException e) {
            System.out.println("A technical error has occurred");

        } catch (Exception e) {
            e.printStackTrace();
        }

        scan.close();
    }
}