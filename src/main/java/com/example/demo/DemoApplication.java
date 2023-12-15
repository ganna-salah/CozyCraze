package com.example.demo;


import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		registerUser("sandra","sandrabassem2002@gmail.com","01200559178","sandra_bassem","123456sandra");

	}

	public static void registerUser(String name, String Email, String username, String phone, String password) {
        DemoUser user = new DemoUser(name,Email,phone,username,password);
        try{
            Connection connection=DemoDBUtil.getConnection();
            PreparedStatement statement= connection.prepareStatement("INSERT INTO tbl_customer (C_name,C_Email,C_phone,C_username,C_password) VALUES ( '" + name + "','" +Email+"','"+ phone + "','" + username + "','" + password + "')");
        }
        catch(Exception e){            
            e.printStackTrace();
        }

    }

	
}
