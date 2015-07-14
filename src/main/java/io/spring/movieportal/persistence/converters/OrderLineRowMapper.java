package io.spring.movieportal.persistence.converters;

import io.spring.movieportal.model.order.OrderLine;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class OrderLineRowMapper implements RowMapper<OrderLine> {
    public OrderLine mapRow(ResultSet resultSet, int i) throws SQLException {
        OrderLine orderLine = new OrderLine();
        orderLine.setOrderLineId(resultSet.getInt("ORDERLINE_ID"));
        orderLine.setMovieId(resultSet.getInt("MOVIE_ID"));
        orderLine.setPurchasePrice(resultSet.getFloat("PURCHASE_PRICE"));
        orderLine.setDiscount(resultSet.getInt("DISCOUNT_PERCENT"));
        return orderLine;
    }
}
