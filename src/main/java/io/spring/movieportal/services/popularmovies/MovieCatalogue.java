package io.spring.movieportal.services.popularmovies;


import io.spring.movieportal.model.movie.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class MovieCatalogue {

    private HashMap<Integer, ArrayList<Movie>> boxOffice = new HashMap<Integer, ArrayList<Movie>>();
    private HashMap<String, ArrayList<Movie>> recommended = new HashMap<String, ArrayList<Movie>>();

    public void registerBoxOfficeMovieByYear(Movie movie) {
        ArrayList<Movie> movies = boxOffice.get(movie.getYear());
        if(movies == null) {
            movies = new ArrayList<Movie>();
        }
        movies.add(movie);
        boxOffice.put(movie.getYear(), movies);
    }

    public void deRegisterBoxOfficeMovieByYear(Movie movie) {
        ArrayList<Movie> movies = boxOffice.get(movie.getYear());
        movies.remove(movie);
        boxOffice.put(movie.getYear(), movies);
    }
}
