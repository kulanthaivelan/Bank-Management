package com.revature.app;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.revature.util.ConnectionManager;

public class Account_Balance {
	public static double getBalance(int id) throws ClassNotFoundException {
		double balance = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_database","root","Kulanthaivelan#20");
			String sql = "SELECT Balance FROM Bank_Account WHERE Account_ID =? ;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				balance = rs.getFloat("Balance");
				System.out.println("your Balance is :" + balance);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return balance;
	}

	public static void withdrawBalance(float withdrawal,int ACCOUNT_ID) throws SQLException, IOException, ClassNotFoundException {
		double balance = 0;
		
		
		balance = Account_Balance.getBalance(ACCOUNT_ID);
		
		System.out.println(balance);
		if((balance>withdrawal)&&(withdrawal>0)){
			try {
				Class.forName("com.mysql.jdbc.Driver");  
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_database","root","Kulanthaivelan#20");
				balance = balance - withdrawal;
				CallableStatement cstmt = conn.prepareCall(" UPDATE Bank_Account SET Balance = ? WHERE Account_ID = ?;");
				cstmt.setDouble(1, balance);
				cstmt.setInt(2, ACCOUNT_ID);
				System.out.println("your current Balance is :" + balance);
				cstmt.execute();
			}catch (SQLException e) {
				e.printStackTrace();
			}}
		
			
			
			else System.out.println("Insufficient funds for this transaction");
		


		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_database","root","Kulanthaivelan#20");
			CallableStatement cstmt = conn.prepareCall("update TRANSACTIONS set AMOUNT = ? where Account_ID=?;");
			cstmt.setDouble(1, withdrawal*-1);
			cstmt.setInt(2, ACCOUNT_ID);
			cstmt.execute();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	
	
	
		System.out.println("Cash Withdrawn");

	}
	public static void DepositBalance(float deposit,int ACCOUNT_ID) throws SQLException, IOException, ClassNotFoundException {
		double balance = 0;
		balance = Account_Balance.getBalance(ACCOUNT_ID);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_database","root","Kulanthaivelan#20");
				balance = balance + deposit;
				CallableStatement cstmt = conn.prepareCall("UPDATE Bank_Account SET Balance = ? WHERE Account_ID = ?");
				cstmt.setDouble(1, balance);
				System.out.println(ACCOUNT_ID);
				cstmt.setInt(2, ACCOUNT_ID);
				cstmt.execute();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
			balance = Account_Balance.getBalance(ACCOUNT_ID);

			System.out.println(balance);
/*try{Class.forName("com.mysql.jdbc.Driver");  
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_database","root","Tamilchandru@9600");
				balance = balance + deposit;
				CallableStatement cstmt = conn.prepareCall("INSERT INTO TRANSACTIONS\r\n" + 
						"(AMOUNT, Account_ID)\r\n" + 
						"VALUES\r\n" + 
						"(?, ?");
				cstmt.setDouble(1, deposit);
				System.out.println(deposit);
				cstmt.setInt(2, ACCOUNT_ID);
				 System.out.println(ACCOUNT_ID);
				cstmt.execute();
			}catch (SQLException e) {
				e.printStackTrace();
			}*/
		System.out.println("Cash Deposited");

	}
}