package io.spring.movieportal.persistence.movie;

import io.spring.movieportal.model.movie.Movie;
import io.spring.movieportal.persistence.converters.MovieRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MovieRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Movie getMovieById(int movieId) {
        String selectSQL = "SELECT * FROM MOVIES WHERE MOVIE_ID = ?";
        Movie movie;
        try {
            movie = jdbcTemplate.queryForObject(selectSQL, new MovieRowMapper(), movieId);
        } catch (EmptyResultDataAccessException er) {
            movie = null;
        }

        return movie;
    }

    public List<Movie> getMoviesByGenre(String genre) {
        String selectSQL = "SELECT * FROM MOVIES WHERE MOVIE_GENRE = ?";
        return jdbcTemplate.query(selectSQL, new String[]{genre}, new MovieRowMapper());
    }

    public List<Movie> getMoviesByYear(int year) {
        String selectSQL = "SELECT * FROM MOVIES WHERE MOVIE_YEAR = ?";
        return jdbcTemplate.query(selectSQL, new Integer[]{year}, new MovieRowMapper());
    }

    public List<Movie> getAllMovies() {
        String selectSQL = "SELECT * FROM MOVIES";
        return jdbcTemplate.query(selectSQL, new MovieRowMapper());
    }


}
