package de.uniba.dsam.group.project.services;

import de.uniba.dsam.group.project.models.CartItem;
import de.uniba.dsam.group.project.repos.CartItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static de.uniba.dsam.group.project.models.Cart.cartItems;

@Service
public class CartServiceImpl implements CartService{

    private final CartItemRepository cartItemRepository;

    public CartServiceImpl(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public void saveToCart(CartItem cartItem) {
        this.cartItemRepository.save(cartItem);
    }

    @Override
    public List<CartItem> findAllBeveragesInCart() {
        return this.cartItemRepository.findAll();
    }

    @Override
    public Boolean deleteCartItemById(Long id) {
        if (this.cartItemRepository.findById(id).isPresent()){
            cartItemRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void deleteAllCartItems() {
        cartItemRepository.deleteAll();

    }
    @Override
    public void clearCart() {
        cartItems.clear();
    }


}

