package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServicesIMPL implements DemoServices {

    @Autowired
    static List<DemoUser> users = new ArrayList();
    Connection connection;

    public DemoServicesIMPL() throws SQLException{
        connection=DemoDBUtil.getConnection();
    }

    @Override
    public boolean validateLogin(String username ,String password) {
        try{
        PreparedStatement statement=connection.prepareStatement("select C_username,C_password from tbl_customer");
        ResultSet resultset=statement.executeQuery();
        while(resultset.next()){
            if(username.equals(resultset.getString("C_username")) && password.equals(resultset.getString("C_password"))){
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
    public void  registerUser(String name, String Email, String username, String phone, String password) {
        DemoUser user = new DemoUser(name,Email,phone,username,password);
        try{
            PreparedStatement statement= connection.prepareStatement("INSERT INTO tbl_customer (C_name,C_Email,C_phone,C_username,C_password) VALUES ( '" + name + "','" +Email+"','"+ phone + "','" + username + "','" + password + "')");
        }
        catch(Exception e){            
            e.printStackTrace();
        }

    }

}
