package com.project.walmart.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cartItem")
public class CartItem {
    @Id
    private int cartItem_id;
    private int quantity;
    private double totalPrice;

    @ManyToOne
    private Cart cart;
    @OneToOne
    private Product product;

    public CartItem() {
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public CartItem(int cartItem_id, int quantity, double totalPrice, Cart cart, Product product) {
        this.cartItem_id = cartItem_id;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.cart = cart;
        this.product = product;
    }



    public int getCartItem_id() {
        return cartItem_id;
    }

    public void setCartItem_id(int cartItem_id) {
        this.cartItem_id = cartItem_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
