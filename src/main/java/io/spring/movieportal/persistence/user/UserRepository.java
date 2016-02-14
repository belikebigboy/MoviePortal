package io.spring.movieportal.persistence.user;

import io.spring.movieportal.model.user.RegisteredUser;
import io.spring.movieportal.model.user.RegularUser;
import io.spring.movieportal.persistence.converters.RegisteredUserRowMapper;
import io.spring.movieportal.persistence.converters.RegularUserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public RegisteredUser getRegisteredUserbyId(int userId) {
        String selectSQL = "SELECT * FROM USERS WHERE USER_ID = ? AND USER_TYPE=1";
        RegisteredUser user;
        try {
            user = jdbcTemplate.queryForObject(selectSQL, new RegisteredUserRowMapper(), userId);
        } catch (EmptyResultDataAccessException er) {
            user = null;
        }

        return user;
    }

    public void createRegularUser(RegularUser user) {

    }

    public void createRegisteredUser(final RegisteredUser user) {
        String insertSQL = "INSERT INTO USERS (USER_ID, USER_NAME, USER_EMAIL, USER_TYPE, FIRST_NAME, LAST_NAME, PAYMENT_INFO, DISCOUNT_RATE, CREATION_DATE, PASSWORD) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(insertSQL, new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1, user.getUserId());
                preparedStatement.setString(2, user.getUserName());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setInt(4, user.getUserStatus().code());
                preparedStatement.setString(5, user.getFirstName());
                preparedStatement.setString(6, user.getLastName());
                preparedStatement.setString(7, user.getPaymentInfo());
                preparedStatement.setFloat(8, user.getDiscountRate());
                preparedStatement.setDate(9, new Date(System.currentTimeMillis()));
                preparedStatement.setString(10, user.getPassword());
            }
        });
    }


    public boolean upgradeUser(final int userId) {
        String updateSQL = "UPDATE USERS SET USER_TYPE=1 WHERE USER_ID=?";
        int result = jdbcTemplate.update(updateSQL, new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1, userId);
            }
        });

        return result == 1;
    }

    public List<RegularUser> getRegularUsers() {
        String selectSQL = "SELECT * FROM USERS WHERE USER_TYPE=0";
        return jdbcTemplate.query(selectSQL, new RegularUserRowMapper());
    }

    public int deleteRegularUserById(final int userId) {
        String deleteSQL = "DELETE FROM USERS WHERE USER_TYPE=0 AND USER_ID =?";

        return jdbcTemplate.update(deleteSQL, new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1, userId);
            }
        });
    }
}
