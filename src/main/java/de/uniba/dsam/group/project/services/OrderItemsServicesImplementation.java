package de.uniba.dsam.group.project.services;

import de.uniba.dsam.group.project.models.OrderItem;
import de.uniba.dsam.group.project.repos.OrderItemsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemsServicesImplementation implements OrderItemsService {
    private final OrderItemsRepository orderItemsRepository;

    public OrderItemsServicesImplementation(OrderItemsRepository orderItemsRepository) {
        this.orderItemsRepository = orderItemsRepository;
    }




    @Override
    public void createOrderItem(OrderItem item) {
        this.orderItemsRepository.save(item);
    }

    @Override
    public List<OrderItem> findAllOrders() {
        return this.orderItemsRepository.findAll();
    }




}

