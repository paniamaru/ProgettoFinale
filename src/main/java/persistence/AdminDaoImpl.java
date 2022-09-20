package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Util.DataBase;
import Util.Hash;
import model.Admin;

public class AdminDaoImpl implements AdminDao {

	public Admin getAdmin(Admin user) {

		try {
			Connection connection = DataBase.getInstance().getConnection();
			//Connection connection = DriverManager
			//		.getConnection("jdbc:mysql://localhost:3306/ass_5?user=root&password=test&serverTimezone=UTC");
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM `ass_5`.`user` WHERE ID=? AND Password=?");
			stmt.setString(1, user.getID());
			stmt.setString(2, Hash.hash(user.getPassword() + user.getID()));
//		    System.out.println(""+hash(user.getPassword()+user.getID()+""));
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// System.out.println(rs.getString(1)+", "+rs.getString(2));
				user.setID(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setNome(rs.getString(3));
				user.setCognome(rs.getString(4));
				user.setAdmin(rs.getBoolean(5));
//				connection.close();
				return user;
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException("Admin.AdminDaoImpl: " + e.toString());
		}
	}

	public void addAdmin(String User, String Pass) {

		try {
			Connection connection = DataBase.getInstance().getConnection();
			//Connection connection = DriverManager
			//		.getConnection("jdbc:mysql://localhost:3306/ass_5?user=app&password=000&serverTimezone=UTC");
			PreparedStatement stmt = connection
					.prepareStatement("INSERT INTO `ass_5`.`user` (`ID`,`Password`) VALUES (?, ?);");
			stmt.setString(1, User);
			stmt.setString(2, Hash.hash(Pass + User));

			if (stmt.executeUpdate() == 1) {
				System.out.println("OK!");
			} else {
				System.out.println("Nope!");
			}

		} catch (SQLException e) {
			throw new RuntimeException("Admin.AdminDaoImpl: " + e.toString());
		}
	}
}