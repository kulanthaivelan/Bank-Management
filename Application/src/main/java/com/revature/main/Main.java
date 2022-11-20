package com.revature.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.app.Bank_user;
import com.revature.app.Login;
import com.revature.dao.Daoimplementation;

public class Main {
	public static void main(String[] args) throws SQLException, IOException, InterruptedException, ClassNotFoundException  {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String choice;
		
		System.out.println(" Welcome to Bandhan Bank ");
		System.out.println(" ***************************** ");
	   
		boolean choices = true;
		while(choices) {  System.out.println("Do you have an account ?");

	    System.out.println("enter : yes or no");
	    choice = input.nextLine(); 
	    switch(choice)
	    {
	        case "yes":
	        	choices = false;
	            Login login = new Login();
	            
	            break;

	        case "no":
	        	System.out.println("Alright. Let's set up an account for you");
	            
	            Daoimplementation user = new Daoimplementation();
	            Bank_user users = user.createUser();
	            choices= false;
	            Login nulogin = new Login(users);
	            
	            break;
	    }
		
	}
	  System.out.println("Thank you for banking with us");
	}
}
