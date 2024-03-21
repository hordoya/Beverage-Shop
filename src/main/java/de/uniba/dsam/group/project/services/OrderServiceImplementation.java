package de.uniba.dsam.group.project.services;

import de.uniba.dsam.group.project.models.Order;
import de.uniba.dsam.group.project.repos.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImplementation implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImplementation(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public List<Order> findAllOrders() {
        return this.orderRepository.findAll();
    }

    @Override
    public void createOrder(Order order){
        this.orderRepository.save(order);
    }
}

