package de.uniba.dsam.group.project.controllers;


import de.uniba.dsam.group.project.models.*;
import de.uniba.dsam.group.project.services.BeverageService;
import de.uniba.dsam.group.project.services.CartService;
import de.uniba.dsam.group.project.services.OrderService;
import de.uniba.dsam.group.project.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    private BeverageService beverageService;
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderService orderService;

//    @Autowired
//    public CartController(BeverageService beverageService, CartService cartService, OrderService orderService) //constructor
//    {
//        this.beverageService = beverageService;
//        this.cartService = cartService;
//        this.orderService = orderService;
//
//    }

    @PostMapping("/addToCart/bottle/{productId}")
    public String addBottleToCart(@PathVariable Long productId, Model model,@RequestParam("quantity") int quantity) {
        Bottle bottle = (Bottle) this.beverageService.findBeverageById(productId);
        if (bottle != null) {
            CartItem cartItem = new CartItem();
            cartItem.setBeverage(bottle);
            cartItem.setQuantity(quantity);
            this.cartService.saveToCart(cartItem);
        }
        return "redirect:/";
    }

    @PostMapping("/addToCart/crate/{productId}")
    public String addCrateToCart(@PathVariable Long productId, Model model,@RequestParam("quantity") int quantity) {
        Crate crate = (Crate) this.beverageService.findBeverageById(productId);
        if (crate != null) {
            CartItem cartItem = new CartItem();
            cartItem.setBeverage(crate);
            cartItem.setQuantity(quantity);
            this.cartService.saveToCart(cartItem);//save to cart
        }
        return "redirect:/";
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        List<CartItem> cartItems = cartService.findAllBeveragesInCart();
        Cart cart = new Cart();
        cart.setCartItems(cartItems);
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("cart", cart);
        model.addAttribute("totalAmount", cart.calculateTotalAmount());
        return "view-cart";
    }

    @PostMapping("/cart/delete/{itemId}")
    public String deleteCartItem(@PathVariable Long itemId) {
        this.cartService.deleteCartItemById(itemId);
        return "redirect:/cart";
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


