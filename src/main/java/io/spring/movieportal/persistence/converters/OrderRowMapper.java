package io.spring.movieportal.persistence.converters;


import io.spring.movieportal.model.order.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order> {

    public Order mapRow(ResultSet resultSet, int i) throws SQLException {
        Order order = new Order();
        order.setOrderId(resultSet.getInt("ORDER_ID"));
        order.setUserId(resultSet.getInt("USER_ID"));
        order.setIsLimited(resultSet.getBoolean("IS_LIMITED"));
        order.setOrderDate(resultSet.getDate("CREATION_DATE"));
        order.setOrderNo(resultSet.getString("ORDER_NO"));
        return order;
    }
}
