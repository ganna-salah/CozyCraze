package com.example.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

class DemoServicesIMPL implements DemoServices {

public static DemoUser currentUser;

    @Autowired
    //static ArrayList<DemoUser> users = new ArrayList();
    Connection connection;

    public DemoServicesIMPL() {//CONSTRUCTOR
        try{
        connection=DemoDBUtil.getConnection();}
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean validateLogin(String username ,String password) {
        try{
        Statement mystate =connection.createStatement();
        ResultSet resultset=mystate.executeQuery("select * from tbl_customer");
        while(resultset.next()){
            if(username.equals(resultset.getString("C_username")) && password.equals(resultset.getString("C_password"))){
                currentUser=new DemoUser();
                currentUser.setName(resultset.getString("C_Name"));
                currentUser.setEmail(resultset.getString("C_Email"));
                currentUser.setPhone(resultset.getString("C_phone"));
                currentUser.setUsername(resultset.getString("C_Username"));
                return true;
            }
        }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void  registerUser(String name, String Email, String phone,  String username,String password) {
        DemoUser user = new DemoUser(name,Email,phone,username,password);
        System.out.println(user.toString());
        try{
            Statement statement= connection.createStatement();
            statement.executeUpdate("INSERT INTO tbl_customer (C_name,C_Email,C_phone,C_username,C_password) VALUES ( '" + name + "','" +Email+"','"+ phone + "','" + username + "','" + password + "')");
            System.out.println(statement);
        }
        catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }

    }

}
