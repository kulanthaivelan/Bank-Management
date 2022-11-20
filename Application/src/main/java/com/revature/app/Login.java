package com.revature.app;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Login {
	
	public Login() throws SQLException, IOException, InterruptedException, ClassNotFoundException{

		Bank_user c = null;
		String choice;
		String username = null;
		String password = null;
		boolean choices = true;
		
		  while(choices) { System.out.println("Please enter your username");
		   @SuppressWarnings("resource")
		   Scanner input = new Scanner (System.in);
		     username = input.nextLine();
		    System.out.println("Please enter your password");
		     password = input.nextLine();

		try  {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection conn=DriverManager.getConnection( "jdbc:mysql://localhost:3306/bank_database","root","Kulanthaivelan#20"); 
			String sql = " SELECT COUNT(Username)\r\n" + 
					"  FROM Bank_User\r\n" + 
					" WHERE Username = ? AND\r\n" + 
					"       Password0 = ?\r\n" + 
					" LIMIT 0, 1;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs= pstmt.executeQuery();

			while(rs.next()) {
				
				int checker = rs.getInt("COUNT(Username)");
				
				if(checker==1) {
					
					
					System.out.println("Logging You in");
					System.out.print(" * "+" * "+" * ");
					
					choices=false;
					
				}
				else {
					
					System.out.println(" Not Found");
				}
								
						
								
							}}
		finally {
			System.out.println(" ");
		}
		  }
			try {
				Class.forName("com.mysql.jdbc.Driver");  
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_database","root","Kulanthaivelan#20"); 
				String sql = "SELECT *\r\n" + 
						"  FROM Bank_User\r\n" + 
						" WHERE Username = ? AND\r\n" + 
						"       Password0 = ?" +
						" LIMIT 0, 1;";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				ResultSet rs= pstmt.executeQuery();

				while(rs.next()) {
					
					int ACCOUNT_ID = rs.getInt("Account_ID");
					
					int USER_ID = rs.getInt("User_ID");
					String USER_FIRSTNAME= rs.getString("FirstName");
					String USER_LASTNAME = rs.getString("LastName");
					String USER_NAME = rs.getString("Username");
					c= new Bank_user(USER_ID,USER_FIRSTNAME,USER_LASTNAME,ACCOUNT_ID,USER_NAME);
					
						
					}
					
									
							
									
								
			System.out.println(c.getUserName());
if (c.getUserName().equals("Tamilsri")) {choices = true;
			
			while(choices)
			{
			    System.out.println("What would you like to do");
			    @SuppressWarnings("resource")
				Scanner input = new Scanner (System.in);
			   
			   

			    System.out.println("Please Enter the options below:");
			    System.out.println("check balance");
			    System.out.println("deposit");
			    System.out.println("withdraw");
			    System.out.println("view all accounts");
			    System.out.println("view account");
			    System.out.println("delete account");
			    System.out.println("view transactions");
			    System.out.println("logout");
			    choice = input.nextLine();


			    switch(choice)
			    {
			        case "check balance":
			        	float bal = (float) Account_Balance.getBalance(c.getAccid());
			        	System.out.println("Your balance is : $"+bal );
			            
			            break;

			        case "deposit":
			           
			            c.Deposit(c.getAccid());
			            break;
			        case "withdraw":
			        	c.Withdraw(c.getAccid());
			        case "logout":
			        	choices = false;
			        	break;
			        case "view all accounts":
			        	Admin.ViewAllAccounts();
			        	break;
			        case "delete account":
			        	Scanner dep2 = new Scanner(System.in);
			    		int accid = 0;
			    		boolean isint = false;

			    		while (isint == false) {
			    			try {
			    				System.out.println("Please enter the users account ID");
			    				String tempdep = dep2.nextLine();
			    				accid = Integer.parseInt(tempdep);
			    				isint = true;
			    				 Admin.DeleteAccount(accid);
			    			} 
			    			catch (InputMismatchException d) {

			    			} 
			    			catch (NumberFormatException e) {
			    			}
			    		}
			        	
			       
			        case "view transactions":
			        	Scanner dep4 = new Scanner(System.in);
			    		int accid2 = 0;
			    		boolean isint2 = false;

			    		while (isint2 == false) {
			    			try {
			    				System.out.println("Please enter the users account ID");
			    				String tempdep = dep4.nextLine();
			    				accid2 = Integer.parseInt(tempdep);
			    				isint2 = true;
			    				 Admin.viewTransactions(accid2);
			    			} catch (InputMismatchException d) {

			    			} catch (NumberFormatException e) {
			    			}}
			        
			        case "view account":
			        	
			        	Scanner dep3 = new Scanner(System.in);
			    		int accid1 = 0;
			    		boolean isint1 = false;

			    		while (isint1 == false) {
			    			try {
			    				System.out.println("Please enter the users account ID");
			    				String tempdep = dep3.nextLine();
			    				accid1 = Integer.parseInt(tempdep);
			    				isint1 = true;
			    				 Admin.DeleteAccount(accid1);
			    			} catch (InputMismatchException d) {

			    			} catch (NumberFormatException e) {
			    			}
			    		}
			        
			    }
			}
	
			}else{
				choices = true;
			}
			
			while(choices)
			{
			    System.out.println("What would you like to do?");
			    @SuppressWarnings("resource")
				Scanner accin = new Scanner (System.in);
			   
			   

			    System.out.println("Please enter your option below:");

			   
			    System.out.println("check balance");
			    System.out.println("deposit");
			    System.out.println("withdraw");
			    System.out.println("logout");
			    System.out.println("enter :");
			    choice = accin.nextLine();


			    switch(choice)
			    {
			        case "check balance":
			            c.CheckBalance();
			            
			            break;

			        case "deposit":
			           
			            c.Deposit(c.getAccid());
			            break;
			        case "withdraw":
			        	c.Withdraw(c.getAccid());
			        case "logout":
			        	choices = false;
			        	break;

			        default:
			            System.out.println("please enter again ");
			            boolean repeat = true;

			            while (repeat)
			            {
			            	System.out.println("enter :");
						    System.out.println("check balance");
						    System.out.println("deposit");
						    System.out.println("withdraw");
						    System.out.println("logout");
			                choice = accin.nextLine();

			                switch (choice)
			                {

					        case "check balance":
					        	repeat = false;
					            c.CheckBalance();
					            
					            break;

					        case "deposit":
					        	repeat = false;
					           
					            c.Deposit(c.getAccid());
					            break;
					        case "withdraw":
					        	repeat = false;
					        	c.Withdraw(c.getAccid());
					        case "logout":
					        	choices = false;
					        	repeat = false;
					        	break;
			                }
			            }
			            break;
			    }
			}
	
			}
			finally {
				System.out.println(" ");
			}
	}
	public Login(Bank_user c) throws SQLException, IOException, ClassNotFoundException{
		System.out.println("Welcome to Revature Bank");
		
		String choice;


			boolean choices = true;
			
			while(choices)
			{
			    System.out.println("What would you like to do?");
			    @SuppressWarnings("resource")
				Scanner input = new Scanner (System.in);
			   
			   

			    System.out.println("Please enter your option (case sensitive)");

			    System.out.println("enter :");
			    System.out.println("check balance");
			    System.out.println("deposit");
			    System.out.println("withdraw");
			    System.out.println("logout");
			    choice = input.nextLine();


			    switch(choice)
			    {
			        case "check balance":
			        	float bal = (float) Account_Balance.getBalance(c.getAccid());
			        	System.out.println("Your balance is : $"+bal );
			            
			            break;

			        case "deposit":
			           
			            c.Deposit(c.getAccid());
			            break;
			        case "withdraw":
			        	c.Withdraw(c.getAccid());
			        case "logout":
			        	choices = false;
			        	break;

			        default:
			            System.out.println("please enter again ");
			            boolean repeat = true;

			            while (repeat)
			            {
			            	System.out.println("enter :");
						    System.out.println("check balance");
						    System.out.println("deposit");
						    System.out.println("withdraw");
						    System.out.println("logout");
			                choice = input.nextLine();

			                switch (choice)
			                {

					        case "check balance":
					        	repeat = false;
					            c.CheckBalance();
					            
					            break;

					        case "deposit":
					        	repeat = false;
					           
					            c.Deposit(c.getAccid());
					            break;
					        case "withdraw":
					        	repeat = false;
					        	c.Withdraw(c.getAccid());
					        case "logout":
					        	choices = false;
					        	repeat = false;
					        	break;
			                }
			            }
			            break;
			    }
			}
	
		
		
		
		
		
		
	}
	

}