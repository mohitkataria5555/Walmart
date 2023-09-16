package com.project.walmart.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int product_id;
    private String product_name;
    private double product_price;
    private boolean stock;
    private int product_quantity;
    private boolean live;
    private String product_Image;
    private String product_desc;

    public Product(){

    }

    public Product(int product_id, String product_name, double product_price, boolean stock, int product_quantity,
                   boolean live, String product_Image, String product_desc) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.stock = stock;
        this.product_quantity = product_quantity;
        this.live = live;
        this.product_Image = product_Image;
        this.product_desc = product_desc;
    }

    public int getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public double getProduct_price() {
        return product_price;
    }

    public boolean isStock() {
        return stock;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }

    public int getProduct_quantity() {
        return product_quantity;
    }

    public boolean isLive() {
        return live;
    }

    public String getProduct_Image() {
        return product_Image;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }



    public void setProduct_quantity(int product_quantity) {
        this.product_quantity = product_quantity;
    }

    public void setLive(boolean live) {
        this.live = live;
    }



    public void setProduct_Image(String product_Image) {
        this.product_Image = product_Image;
    }

    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }
}
