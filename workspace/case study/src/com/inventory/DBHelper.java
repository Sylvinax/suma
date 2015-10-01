package com.inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

	public static Connection connect() throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.OracleDriver");     
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","esguser","esguser123");
	}
}
