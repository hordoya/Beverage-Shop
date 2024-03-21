package de.uniba.dsam.group.project.services;

import de.uniba.dsam.group.project.models.CartItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
    void saveToCart(CartItem cartItem);

    List<CartItem> findAllBeveragesInCart();

    Boolean deleteCartItemById(Long id);

    void deleteAllCartItems();

    void clearCart();
}
