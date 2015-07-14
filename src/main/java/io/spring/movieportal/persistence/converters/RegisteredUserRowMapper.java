package io.spring.movieportal.persistence.converters;


import io.spring.movieportal.model.user.RegisteredUser;
import io.spring.movieportal.model.user.UserStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisteredUserRowMapper implements RowMapper<RegisteredUser> {

    public RegisteredUser mapRow(ResultSet rs, int rowNum) throws SQLException {

        RegisteredUser user = new RegisteredUser();
        user.setUserId(rs.getInt("USER_ID"));
        user.setEmail(rs.getString("USER_EMAIL"));
        user.setUserName(rs.getString("USER_NAME"));
        int userType = rs.getInt("USER_TYPE");
        switch (userType) {
            case 0:
                user.setUserStatus(UserStatus.regular);
            case 1:
                user.setUserStatus(UserStatus.registered);
            default:
                user.setUserStatus(UserStatus.unknown);
        }
        user.setFirstName(rs.getString("FIRST_NAME"));
        user.setLastName(rs.getString("LAST_NAME"));
        user.setPaymentInfo(rs.getString("PAYMENT_INFO"));
        user.setDiscountRate(rs.getFloat("DISCOUNT_RATE"));
        user.setCreationDate(rs.getDate("CREATION_DATE"));
        return user;
    }
}
