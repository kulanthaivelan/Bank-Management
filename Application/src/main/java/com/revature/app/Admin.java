package com.revature.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin {

	public static void ViewAllAccounts() throws ClassNotFoundException {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_database","root","Kulanthaivelan#20");
			String sql = "SELECT * FROM Bank_User";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				
				int id = rs.getInt("User_ID");
				int input = rs.getInt("Account_ID");
				String Name= rs.getString("Username");

				String fname = rs.getString("FirstName");
				String lname = rs.getString("LastName");
				
				System.out.println("USER ID:"+id +" | USER ACCOUNT:"+ input +" | USER NAME:"+ Name+" | NAME:" + fname +" "+ lname );

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
public static void DeleteAccount(int input) throws ClassNotFoundException {
		
	float balance = 0;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");  
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_database","root","Kulanthaivelan#20");
		
			String sql = "SELECT *FROM Bank_user where Account_ID = ?;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				
				int id = rs.getInt("User_ID");
				int input1 = rs.getInt("Account_ID");
				String Name= rs.getString("Username");

				String fname = rs.getString("FirstName");
				String lname = rs.getString("LastName");
				
				System.out.println("USER ID:"+id +" | USER ACCOUNT:"+ input1 +" | USER NAME:"+ Name+" | NAME:" + fname +" "+ lname + " | BALANCE:" + balance);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	try {
		Class.forName("com.mysql.jdbc.Driver");  
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_database","root","Kulanthaivelan#20");
		
			String sql = "SELECT *FROM Bank_Account where Account_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				balance = rs.getFloat("Balance");
			}
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
	if (balance == 0) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_database","root","Kulanthaivelan#20");
			String sql = "DELETE *FROM Bank_Account WHERE Account_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			pstmt.execute();
			sql = "DELETE * FROM Bank_User WHERE Account_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			pstmt.execute();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	else {System.out.println("");
		System.out.println("cannot delete user. The user has funds in their account");}
		
	}

static void viewAccount(int input) throws ClassNotFoundException {
	try {
		Class.forName("com.mysql.jdbc.Driver");  
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_database","root","Kulanthaivelan#20");
		String sql = "SELECT * FROM Bank_User";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			
			int id = rs.getInt("User_ID");
			int input1 = rs.getInt("Account_ID");
			String Name= rs.getString("Username");

			String fname = rs.getString("FirstName");
			String lname = rs.getString("LastName");
			
			System.out.println("USER ID:"+id +" | USER ACCOUNT:"+ input1 +" | USER NAME:"+ Name+" | NAME:" + fname +" "+ lname );

		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	try {
		Class.forName("com.mysql.jdbc.Driver");  
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_database","root","Kulanthaivelan#20");
		String sql = "SELECT * FROM Bank_Account where Account_ID = ?;";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, input);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {

			float balance = rs.getFloat("Balance");
			
			int id = rs.getInt("User_ID");
			int input1 = rs.getInt("Account_ID");
			String Name= rs.getString("Username");

			String fname = rs.getString("FirstName");
			String lname = rs.getString("LastName");
			
			System.out.println("USER ID:"+id +" | USER ACCOUNT:"+ input1 +" | USER NAME:"+ Name+" | NAME:" + fname +" "+ lname + " | BALANCE:" + balance);

		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}

static void viewTransactions(int input) throws ClassNotFoundException {
	
	try {
		Class.forName("com.mysql.jdbc.Driver");  
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_database","root","Kulanthaivelan#20");
		String sql = "SELECT * FROM TRANSACTIONS WHERE Account_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, input);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {

			float balance = rs.getFloat("AMOUNT");
			
			
			int input1 = rs.getInt("ACCOUNT_ID");

			int TRANSACTIONID = rs.getInt("TRANSID");
			
			
			System.out.println("USER ACCOUNT:"+ input1 + " | AMOUNT:" + balance+  " | TRANSACTION ID:" + TRANSACTIONID);

		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	
	
	
	
	
}
	
}