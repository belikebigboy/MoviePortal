package io.spring.movieportal.persistence.order;

import io.spring.movieportal.model.order.Order;
import io.spring.movieportal.model.order.OrderLine;
import io.spring.movieportal.persistence.converters.OrderLineRowMapper;
import io.spring.movieportal.persistence.converters.OrderRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void createNewOrder(Order order) {

    }

    public void createNewOrderLine(OrderLine order) {

    }

    public List<Order> getOrdersByUser(int userId) {
        String selectSQL = "SELECT * FROM ORDERS WHERE USER_ID = ?";
        return jdbcTemplate.query(selectSQL, new Integer[]{userId}, new OrderRowMapper());
    }

    public List<OrderLine> getOrderLinesByOrderId(int orderId) {
        String selectSQL = "SELECT * FROM ORDERLINE WHERE ORDER_ID = ?";
        return jdbcTemplate.query(selectSQL, new Integer[]{orderId}, new OrderLineRowMapper());
    }

}
