package io.spring.movieportal.controller;

import io.spring.movieportal.model.movie.Movie;
import io.spring.movieportal.services.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/movies" , method = RequestMethod.GET)
    public Movie getMovieById(@RequestParam(value = "id") int movieId) {
        return movieService.getMovieById(movieId);
    }

    @RequestMapping(value = "/movies/year/{year}" , method = RequestMethod.GET)
    public List<Movie> getAllMoviesByYear(@PathVariable int year) {
        return movieService.browseByYear(year);
    }

    @RequestMapping(value = "/movies/genre/{genre}" , method = RequestMethod.GET)
    public List<Movie> getAllMoviesByGenre(@PathVariable String genre) {
        return movieService.browseByGenre(genre);
    }

    @RequestMapping(value = "/movies/all" , method = RequestMethod.GET)
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

}