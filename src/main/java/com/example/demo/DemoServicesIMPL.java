package com.example.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
    public int validateLogin(String username, String password) {
        try {
            Statement mystate = connection.createStatement();
            ResultSet resultSet = mystate.executeQuery("select * from tbl_customer");
            while (resultSet.next()) {
                if (username.equals(resultSet.getString("C_username")) &&
                        passwordEncoder.matches(password, resultSet.getString("C_password"))) {
                    boolean checkAdmin=validateAdmin(resultSet.getString("C_id"));
                    if (checkAdmin) {
                        return 2;
                    }
                    return 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void registerUser(String name, String email, String phone, String username, String password) {
        String encodedPassword = passwordEncoder.encode(password);

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO tbl_customer (C_name, C_Email, C_phone, C_username, C_password) " +
                    "VALUES ('" + name + "','" + email + "','" + phone + "','" + username + "','" + encodedPassword + "')");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }


    @Override
    public void deleteUser(String username) {

        try {
        int id=0;
        Statement mystate = connection.createStatement();
        ResultSet resultSet = mystate.executeQuery("select C_id from tbl_customer where C_username = \"" + username +"\"");
        while(resultSet.next()){
                id=Integer.parseInt(resultSet.getString("C_id"));
            }
            mystate.executeUpdate("DELETE FROM tbl_customer WHERE C_id=" + id );
        }
        catch(Exception e){
            System.out.println(e);
        }
    }


    @Override
    public boolean validateAdmin(String id) {
        if(id.equals("3")){
            return true;
        }
        return false;
    }


    @Override
    public boolean checkUsernameAvailability(String username) {
        try{
        Statement mystate = connection.createStatement();
        ResultSet resultSet = mystate.executeQuery("select C_username from tbl_customer");
            while (resultSet.next()){
                if(resultSet.getString("C_username").equals(username)){
                    return false;
                }                
            }    
    }
        catch(Exception e){
            System.out.println(e);
        }
     return true;
    }
}
