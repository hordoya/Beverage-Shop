package de.uniba.dsam.group.project.services;

import de.uniba.dsam.group.project.models.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAllOrders();
    void createOrder(Order order);

}

