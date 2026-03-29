package com.java.experiment4;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.Statement;
	import java.sql.ResultSet;

public class ProductRetrieval {

	    public static void main(String[] args) {

	        try {
	            // 1 Load Driver
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // 2 Create Connection
	            Connection con = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/productdb",
	                    "root",
	                    "root123"
	            );
	            // 3 Create Statement
	            Statement stmt = con.createStatement();
	            // 4 Execute Query
	            ResultSet rs = stmt.executeQuery("SELECT * FROM product");
	            // 5 Display Data
	            System.out.println("Product Details");

	            while(rs.next())
	            {
	                int id = rs.getInt("id");
	                String name = rs.getString("name");

	                double price = rs.getDouble("price");
	                int quantity = rs.getInt("quantiy");
	                System.out.println(id+" "+name+" "+price+" "+quantity);
	            }

	            // 6 Close Connection
	            con.close();

	        } catch(Exception e) {
	            System.out.println(e);
	        }
	    }
	}

