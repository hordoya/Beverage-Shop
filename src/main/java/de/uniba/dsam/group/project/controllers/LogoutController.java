package de.uniba.dsam.group.project.controllers;

import de.uniba.dsam.group.project.services.CartService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
    private CartService cartService;
    @Autowired
    public LogoutController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/logout")
    public String handleLogout(HttpServletRequest request) {

        this.cartService.clearCart();
        this.cartService.deleteAllCartItems();
        request.getSession().invalidate();
        return "redirect:/login?logout";
    }
}
