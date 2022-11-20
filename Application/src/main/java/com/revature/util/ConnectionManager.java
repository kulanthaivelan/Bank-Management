package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

		public static Connection getConnection(String filename) throws SQLException, IOException, ClassNotFoundException {
			Properties prop = new Properties();

			String url = prop.getProperty("MYSQLJDBC.url");
			String username = prop.getProperty("MYSQLJDBC.username");
			String password = prop.getProperty("MYSQLJDBC.password");

			return 
					DriverManager.getConnection(url, username, password);
		}

}