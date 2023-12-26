package com.example.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;

//@Service
class DemoServicesIMPL implements DemoServices {

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

public static DemoUser currentUser;

    @Autowired
    Connection connection;

    public DemoServicesIMPL() {//CONSTRUCTOR
        try{
        connection=DemoDBUtil.getConnection();
    }
        catch(Exception e){
            e.printStackTrace();
        }
    }


@Override
    public boolean validateLogin(String username, String password) {
        try {
            Statement mystate = connection.createStatement();
            ResultSet resultSet = mystate.executeQuery("select * from tbl_customer");
            while (resultSet.next()) {
                //System.out.println(resultSet.getString("C_password"));
                if (username.equals(resultSet.getString("C_username")) &&
                        passwordEncoder.matches(password, resultSet.getString("C_password"))) {
                    System.out.println("entered");
                    // currentUser = new DemoUser();
                    // currentUser.setName(resultSet.getString("C_Name"));
                    // currentUser.setEmail(resultSet.getString("C_Email"));
                    // currentUser.setPhone(resultSet.getString("C_phone"));
                    // currentUser.setUsername(resultSet.getString("C_Username"));
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void registerUser(String name, String email, String phone, String username, String password) {
        DemoUser user = new DemoUser(name, email, phone, username, password);
        String encodedPassword = passwordEncoder.encode(password);

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO tbl_customer (C_name, C_Email, C_phone, C_username, C_password) " +
                    "VALUES ('" + name + "','" + email + "','" + phone + "','" + username + "','" + encodedPassword + "')");
            // currentUser = new DemoUser();
            // currentUser.setName(name);
            // currentUser.setEmail(email);
            // currentUser.setPhone(phone);
            // currentUser.setUsername(username);
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}



    // @Override
    // public boolean validateLogin(String username ,String password) {
    //     try{
    //     Statement mystate =connection.createStatement();
    //     ResultSet resultset=mystate.executeQuery("select * from tbl_customer");
    //     while(resultset.next()){
    //         if(username.equals(resultset.getString("C_username")) && password.equals(resultset.getString("C_password"))){
    //             currentUser=new DemoUser();
    //             currentUser.setName(resultset.getString("C_Name"));
    //             currentUser.setEmail(resultset.getString("C_Email"));
    //             currentUser.setPhone(resultset.getString("C_phone"));
    //             currentUser.setUsername(resultset.getString("C_Username"));
    //             return true;
    //         }
    //     }
    //     }
    //     catch(Exception e){
    //         e.printStackTrace();
    //     }
    //     return false;
    // }

    // @Override
    // public void  registerUser(String name, String Email, String phone,  String username,String password) {
    //     DemoUser user = new DemoUser(name,Email,phone,username,password);
    //     System.out.println(user.toString());
    //     try{
    //         Statement statement= connection.createStatement();
    //         statement.executeUpdate("INSERT INTO tbl_customer (C_name,C_Email,C_phone,C_username,C_password) VALUES ( '" + name + "','" +Email+"','"+ phone + "','" + username + "','" + password + "')");
    //             currentUser=new DemoUser();
    //             currentUser.setName(name);
    //             currentUser.setEmail(Email);
    //             currentUser.setPhone(phone);
    //             currentUser.setUsername(username);
    //         System.out.println(statement);
    //     }
    //     catch(Exception e){
    //         System.out.println(e);
    //         e.printStackTrace();
    //     }

    // }


