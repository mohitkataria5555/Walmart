package com.project.walmart.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "user_info")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int user_id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true,nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String address;
    private String about;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false,length = 10)
    private String phone;
    @Column(name = "CreateAt")
    private Date date;
    private boolean active;
    @OneToOne(mappedBy = "user")
    private Cart cart;


    public User() {
        super();
    }

    public User(int user_id, String name, String email, String password,
                String address, String about, String gender, String phone, Date date, boolean active, Cart cart) {
        this.user_id = user_id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.about = about;
        this.gender = gender;
        this.phone = phone;
        this.date = date;
        this.active = active;
        this.cart = cart;
    }


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
