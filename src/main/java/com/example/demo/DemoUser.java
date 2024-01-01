package com.example.demo;

public class DemoUser {
    private String name;

    private String Email;

    private String phone;

    private String username;

    private String password;

    DemoUser(){

    }
    DemoUser(String name,String Email, String phone ,String username,String password){
        this.name=name;
        this.Email=Email;
        this.phone=phone;
        this.username=username;
        this.password=password;
    }

    

    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return Email;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public String getPhone() {
        return phone;
    }
    public String getUsername() {
        return username;
    }
    @Override
    public String toString() {
        return name + " " + Email + " " + phone + " " + username + " " + password;
    }


}
