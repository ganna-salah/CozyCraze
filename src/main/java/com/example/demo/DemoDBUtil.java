package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class DemoDBUtil {

    private static Connection connection=null;

    public static Connection getConnection () throws SQLException{ 
        if(connection!= null){
            return connection;
        }
        else{
            String driver= "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/cozy_craze";
            String user ="root";
            String pass= "1234";
            try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url,user,pass);
                }
            catch(Exception e){
                e.printStackTrace();
            }   
        }
            return connection;
    }
}
