package io.spring.movieportal.services.movie;

import io.spring.movieportal.model.movie.Movie;
import io.spring.movieportal.persistence.movie.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie getMovieById(int movieId) {
        return movieRepository.getMovieById(movieId);
    }

    public List<Movie> browseByYear(int year) {
        return movieRepository.getMoviesByYear(year);
    }

    public List<Movie> browseByGenre(String genre) {
        return movieRepository.getMoviesByGenre(genre);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.getAllMovies();
    }

}
