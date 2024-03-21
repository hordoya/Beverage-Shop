package de.uniba.dsam.group.project.services;

import de.uniba.dsam.group.project.models.OrderItem;

import java.util.List;

public interface OrderItemsService {

    void createOrderItem(OrderItem item);
    List<OrderItem> findAllOrders();


}

