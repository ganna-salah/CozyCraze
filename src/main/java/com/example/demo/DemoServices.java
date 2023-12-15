package com.example.demo;

import org.springframework.stereotype.Repository;

@Repository
public interface DemoServices {
    public boolean validateLogin(String username , String password);
    public void registerUser(String name,String Email,String username,String phone,String password);
} 