package com.project.walmart.payload;



import java.util.Date;

public class UserDto {

    private int user_id;
    private String name;
    private String email;
    private String password;
    private String address;
    private String about;
    private String gender;
    private String phone;
    private Date date;
    private boolean active;

    public UserDto() {
        super();
    }

    public UserDto(int user_id, String name, String email, String password, String address,
                   String about, String gender, String phone, Date date, boolean active) {
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
