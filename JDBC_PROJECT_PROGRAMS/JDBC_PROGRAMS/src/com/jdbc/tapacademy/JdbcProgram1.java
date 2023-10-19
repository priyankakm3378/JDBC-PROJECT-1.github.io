package com.jdbc.tapacademy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcProgram1 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/employee";
		//String url = "jdbc:mysql://192.168.0.124:3306/employee";
		
		String username = "root";
		String password = "root";
		String query = "SELECT * FROM emp";
		
		try {
			Connection con = DriverManager.getConnection(url,username,password);
			System.out.println("Connection is established");
			
			Statement stmt = con.createStatement();
			
			ResultSet res = stmt.executeQuery(query);
			
			//System.out.println(res);
			System.out.println("-------------------------------------------------------------------------");
			
			while(res.next()) {
				System.out.printf("| %-5d| %-15s| %-25s| %-7s| %-10s|\n" ,res.getInt(1),res.getString(2),res.getString(3)
				,res.getString(4),res.getString(5));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		System.out.print("-------------------------------------------------------------------------");
		

	}

}
