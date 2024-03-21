package de.uniba.dsam.group.project.controllers;

import de.uniba.dsam.group.project.models.Order;
import de.uniba.dsam.group.project.models.OrderItem;
import de.uniba.dsam.group.project.services.CartService;
import de.uniba.dsam.group.project.services.OrderItemsService;
import de.uniba.dsam.group.project.services.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class OrderController {
    private final OrderService orderService;
    private final OrderItemsService orderItemsService;
    private final CartService cartService;
    public OrderController(OrderService orderService, OrderItemsService orderItemsService, CartService cartService) {
        this.orderService = orderService;
        this.orderItemsService = orderItemsService;
        this.cartService=cartService;
    }





    @GetMapping("/orders")
    public String findAll(Model model) {
        List<OrderItem> orderItems = orderItemsService.findAllOrders();

        model.addAttribute("orderItems", orderItems);
//        model.addAttribute("totalPrice", order.calculateTotalPrice());
        return "orders";
    }
    @GetMapping("/allOrder")
    public String viewOrder(Model model) {
        List<OrderItem> orderItems = orderItemsService.findAllOrders();
        model.addAttribute("orderItems", orderItems);
        return "allOrders";
    }
}

