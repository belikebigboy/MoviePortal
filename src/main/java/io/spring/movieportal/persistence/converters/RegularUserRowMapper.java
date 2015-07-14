package io.spring.movieportal.persistence.converters;

import io.spring.movieportal.model.user.RegularUser;
import io.spring.movieportal.model.user.UserStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class RegularUserRowMapper implements RowMapper<RegularUser> {

    public RegularUser mapRow(ResultSet rs, int i) throws SQLException {
        RegularUser user = new RegularUser();
        user.setUserId(rs.getInt("USER_ID"));
        user.setEmail(rs.getString("USER_EMAIL"));
        int userType = rs.getInt("USER_TYPE");
        switch (userType) {
            case 0:
                user.setUserStatus(UserStatus.regular);
            case 1:
                user.setUserStatus(UserStatus.registered);
            default:
                user.setUserStatus(UserStatus.unknown);
        }

        user.setCreationDate(rs.getDate("CREATION_DATE"));
        return user;
    }
}
