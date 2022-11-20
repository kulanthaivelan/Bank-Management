package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import com.revature.app.Bank_user;


public class Daoimplementation implements database{
		
		private Scanner accin;

		public List<Bank_user> getUser() throws ClassNotFoundException {
			List<> cl = new ArrayList<>();
			try {
				Class.forName("com.mysql.jdbc.Driver");  
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_database","root","Kulanthaivelan#20");
				String sql = "SELECT * FROM Bank_user";
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					
					int USER_ID = rs.getInt("User_ID");
					String USER_FIRSTNAME = rs.getString("FirstName");
					String USER_LASTNAME = rs.getString("LastName");
					String USER_NAME = rs.getString("username");
					int ACCOUNT_ID = rs.getInt("Account_ID");
					cl.add( new Bank_user( USER_ID,  USER_FIRSTNAME,USER_LASTNAME, ACCOUNT_ID,USER_NAME));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return cl;
		}

		@Override
		public Bank_user getUserbyId(int id) throws ClassNotFoundException {
			Bank_user c = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");  
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_database","root","Kulanthaivelan#20");
				String sql = "SELECT * FROM Bank_user WHERE User_ID = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					int USER_ID = rs.getInt("User_ID");
					String USER_FIRSTNAME= rs.getString("FirstName");
					String USER_LASTNAME = rs.getString("LastName");
					String USER_NAME = rs.getString("Username");
					int ACCOUNT_ID = rs.getInt("Account_ID");
					
					c = new Bank_user( USER_ID,  USER_FIRSTNAME,USER_LASTNAME, ACCOUNT_ID,USER_NAME);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return c;
		}


		public Bank_user createUser() throws ClassNotFoundException {
			Bank_user c = null;
			int type = 1;
			int accid = 0;
			double balance = 0;
			
			
			String choice;
			boolean checking = true;
			boolean yn = true;
			while(yn)
			{accin = new Scanner (System.in);
			    System.out.println("Will this be a checking account?");

			    System.out.println("enter : yes or no");
			    choice = accin.nextLine();


			    switch(choice)
			    {
			        case "yes":
			            yn = false;
			            
			            break;

			        case "no":
			            yn = false;
			            checking = false;
			            break;

			        default:
			            System.out.println("please enter again ");
			            boolean repeat = true;

			            while (repeat)
			            {
			                System.out.println("Will this be a checking account? : yes or no");
			                choice = accin.nextLine();

			                switch (choice)
			                {
			                    case "yes":
			                        yn = repeat = false;
			                        break;

			                    case "no":
			                        yn = repeat = false;
			                        checking = false;
			                        break;
			                }
			            }
			            break;
			    }
			}
			if (checking == false) {
				
				type = 0;
			}
			try {
				Class.forName("com.mysql.jdbc.Driver");  
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_database","root","Kulanthaivelan#20");
				String sql = "INSERT INTO Bank_Account (Balance, Type) VALUES (-965, ?);";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, type);
				ResultSet rs;
				pstmt.execute();
				sql = "SELECT * FROM Bank_Account WHERE Balance = -965";
				 pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				while(rs.next()) {
					
					accid = rs.getInt("Account_ID");
				}
				
				    System.out.println("please enter a username");
				    @SuppressWarnings("resource")
					Scanner accin = new Scanner (System.in);
				    String username = accin.nextLine();
				  

				    System.out.println("please enter your first name");
				    String fname = accin.nextLine();
				    
				    System.out.println("please enter your last name");
				    String lname = accin.nextLine();
				    System.out.println("please enter your password");
				    String password = accin.nextLine();
				    
				 sql = "insert into Bank_user(FirstName,LastName,Password0,Account_ID,Username) VALUES(?,?,?,?,?)";
				 pstmt = conn.prepareStatement(sql);
				 pstmt.setString(1, fname);
				 pstmt.setString(2, lname);
				 pstmt.setString(3, password);
				 pstmt.setInt(4, accid);
				 pstmt.setString(5,username);
				 pstmt.execute();
				
					 sql = "UPDATE Bank_Account SET Balance = ? WHERE Account_ID = ? ";
					 pstmt = conn.prepareStatement(sql);
					pstmt.setDouble(1, balance);
					pstmt.setInt(2, accid);
					pstmt.execute();
				
				 sql = "SELECT * FROM Bank_user WHERE Username = ?";
				 pstmt = conn.prepareStatement(sql);
				 pstmt.setString(1,username);
				
				 
				
				rs = pstmt.executeQuery();
				while(rs.next()) {
					
	int ACCOUNT_ID = rs.getInt("User_ID");
					
	int USER_ID = rs.getInt("User_ID");
	String USER_FIRSTNAME= rs.getString("FirstName");
	String USER_LASTNAME = rs.getString("LastName");
	String USER_NAME = rs.getString("Username");
	c= new Bank_user(USER_ID,USER_FIRSTNAME,USER_LASTNAME,ACCOUNT_ID,USER_NAME);
	System.out.println("USER CREATED");
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return c;
			
			
			
			
		}

		@Override
		public void updateUser(Bank_user user) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteUser(Bank_user user){
			final String DELETE_USERS_SQL = "delete from Bank_users where type = 0;";
			 try (Connection connection = DriverManager
			            .getConnection("jdbc:mysql://localhost:3306/mysql_database?useSSL=false", "root", "Kulanthaivelan#20");

			            // Step 2:Create a statement using connection object
			            Statement statement = connection.createStatement();) {

			            // Step 3: Execute the query or update query
			            int result = statement.executeUpdate(DELETE_USERS_SQL);
			            System.out.println("Number of records affected :: " + result);
			        } catch (SQLException e) {

			            // print SQL exception information
			            printSQLException(e);
			        }
		}
		public static void printSQLException(SQLException ex) {
		        for (Throwable e: ex) {
		            if (e instanceof SQLException) {
		                e.printStackTrace(System.err);

		                System.err.println("Deleted Sucessfully " + e.getMessage());
		                Throwable t = ex.getCause();
		                while (t != null) {
		                    System.out.println("Cause: " + t);
		                    t = t.getCause();
		                }
		            }
		        }
		    }

	

	}