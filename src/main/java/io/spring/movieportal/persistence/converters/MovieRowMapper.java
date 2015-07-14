package io.spring.movieportal.persistence.converters;


import io.spring.movieportal.model.movie.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRowMapper implements RowMapper<Movie> {

    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {

        Movie movie = new Movie();
        movie.setId(rs.getInt("MOVIE_ID"));
        movie.setName(rs.getString("MOVIE_NAME"));
        movie.setGenre(rs.getString("MOVIE_GENRE"));
        movie.setYear(rs.getInt("MOVIE_YEAR"));

        return movie;
    }
}
