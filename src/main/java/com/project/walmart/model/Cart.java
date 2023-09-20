package com.project.walmart.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "carts")
public class Cart {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int cart_id;

    @OneToMany()
    private Set<CartItem>  items= new HashSet<>();

    @OneToOne()
    private User user;

    public Set<CartItem> getItems() {
        return items;
    }

    public void setItems(Set<CartItem> items) {
        this.items = items;
    }

    public Cart() {
    }

    public Cart(int cart_id, Set<CartItem> items, User user) {
        this.cart_id = cart_id;
        this.items = items;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cart(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }
}
