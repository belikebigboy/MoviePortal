package io.spring.movieportal.services.subscription;

import io.spring.movieportal.model.movie.Movie;
import io.spring.movieportal.model.order.Order;
import io.spring.movieportal.model.order.OrderLine;
import io.spring.movieportal.model.user.User;
import io.spring.movieportal.persistence.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubscriptionService {

    private OrderRepository orderRepository;

    @Autowired
    public SubscriptionService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void submitOrder(User user, List<Movie> movieList, int period) {

    }

    public void submitLimitedOrder(User user, Movie movie, int period) {

    }

    public List<Order> getAllOrdersForUser(int userId) {
        List<Order> fullOrders = new ArrayList<Order>();
        List<Order> ordersStripped = orderRepository.getOrdersByUser(userId);
        for(Order order : ordersStripped) {
            List<OrderLine> orderLines = orderRepository.getOrderLinesByOrderId(order.getOrderId());
            order.setOrderLines(orderLines);
            fullOrders.add(order);
        }
        return fullOrders;
    }


}
