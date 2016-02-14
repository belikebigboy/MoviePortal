package io.spring.movieportal.controller;


import io.spring.movieportal.model.order.Order;
import io.spring.movieportal.services.subscription.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class OrderController {

    @Autowired
    private SubscriptionService orderService;

    @RequestMapping(value = "/orders/all")
    public List<Order> getAllOrdersForUser(@RequestParam int userId) {
        return orderService.getAllOrdersForUser(userId);
    }
}
