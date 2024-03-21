package de.uniba.dsam.group.project.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Entity
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Transient
    private double totalPrice;
    @OneToMany(cascade = CascadeType.ALL)
    public static Collection<CartItem> cartItems;
    private String sessionToken;
    private int itemsNumber;


    public static Collection<CartItem> getItems() {
        return cartItems;
    }

    public void setCartItems(Collection<CartItem> cartItems) {
        Cart.cartItems = cartItems;
    }
    public double calculateTotalAmount() {
        double sum = 0.0;
        for (CartItem item : this.cartItems) {
            sum += item.getBeverage().getPrice() * item.getQuantity();
        }
        return sum;
    }
}


