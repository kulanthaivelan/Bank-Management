package com.revature.dao;
import java.io.IOException;
import java.util.List;

import com.revature.app.Bank_user;


public interface database {

	public List<Bank_user> getUser() throws IOException, ClassNotFoundException;
	public Bank_user getUserbyId(int id) throws IOException, ClassNotFoundException;
	
	public void updateUser(Bank_user user);
	public void deleteUser(Bank_user user);
	Bank_user createUser() throws ClassNotFoundException;
	
}
