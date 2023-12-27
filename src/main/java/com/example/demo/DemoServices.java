package com.example.demo;

import org.springframework.stereotype.Repository;

@Repository
public interface DemoServices {
    public int validateLogin(String username , String password);
    public void registerUser(String name,String Email,String username,String phone,String password);
    public void deleteUser(String username);
    public boolean validateAdmin(String id);
    public boolean checkUsernameAvailability(String Username);
    
} 