package de.uniba.dsam.group.project.controllers;

import de.uniba.dsam.group.project.models.CartItem;
import de.uniba.dsam.group.project.models.Order;
import de.uniba.dsam.group.project.models.OrderItem;
import de.uniba.dsam.group.project.services.CartService;
import de.uniba.dsam.group.project.services.OrderItemsService;
import de.uniba.dsam.group.project.services.OrderService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
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
        return "orders";
    }
    @GetMapping("/allOrder")
    public String viewOrder(Model model) {
        List<OrderItem> orderItems = orderItemsService.findAllOrders();
        model.addAttribute("orderItems", orderItems);
        return "allOrders";
    }
    @PostMapping("/order/create-order")
    public String createOrder(Model model) {
        List<CartItem> cartItems = this.cartService.findAllBeveragesInCart();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Order order = new Order();
        order.setUsername(username); // Set the username for the order
        List<OrderItem> orderItems = new ArrayList<>();
        for (CartItem cartItem : cartItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setBeverage(cartItem.getBeverage());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPrice(cartItem.getBeverage().getPrice());
            orderItems.add(orderItem);
            order.setPrice(cartItem.getBeverage().getPrice());

        }
        order.setOrderItems(orderItems);
        this.orderService.createOrder(order);
        this.cartService.clearCart();
        this.cartService.deleteAllCartItems();
        return "redirect:/orders";
    }
}

