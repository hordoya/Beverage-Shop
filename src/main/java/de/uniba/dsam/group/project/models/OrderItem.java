package de.uniba.dsam.group.project.models;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;



    @ManyToOne
    @JoinColumn(name = "beverage_id")
    private Beverage beverage;

    private int quantity;
    private double price;




    public OrderItem() {
    }
    public void setOrder(Order order) {
        this.order = order;
    }


    public void setBeverage(Beverage beverage) {
        this.beverage=beverage;
    }

    public void setQuantity(int quantity) {
        this.quantity=quantity;
    }

    public void setPrice(double price) {
        this.price=price;
    }
}

