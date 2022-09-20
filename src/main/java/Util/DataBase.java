package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

	// jdbc:mysql://[host:port], [host:port]/[database] [?propertyName1]
	// [=propertyVa1ue1] [&propertyName2] [=propertyVa1ue2]
	// jdbc:mysql://localhost:3306/ass_5?user=root&password=pippo
	// jdbc:mysql://localhost:3306/ass_5?user=root
	// jdbc:mysql://localhost:3306/sonoo

	String url = "jdbc:mysql://localhost:3306/ass_5?serverTimezone=UTC";
	String login = "root";
	String pwd = "test";
	public static DataBase db;
	public Connection con;

	private DataBase() {
		try {
			con = DriverManager.getConnection(url, login, pwd);
			System.out.println("Connessione Stabilita!");
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}

	public Connection getConnection() {
		return con;
	}

	public static DataBase getInstance() {
		if (db == null)
			db = new DataBase();
		return db;
	}
}
