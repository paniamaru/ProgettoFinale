package persistence;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Elettore;

public class ElettoreDaoImpl  implements ElettoreDao {
	/*
	jdbc:mysql://[host:port], [host:port]/[database] [?propertyName1] [=propertyVa1ue1] [&propertyName2] [=propertyVa1ue2]
	jdbc:mysql://localhost:3306/ass_5?user=root&password=pippo
	jdbc:mysql://localhost:3306/ass_5?user=root
	jdbc:mysql://localhost:3306/sonoo
*/
	public Elettore getElettore(Elettore user){

	try {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ass_5?user=root&password=test&serverTimezone=UTC");
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM `ass_5`.`user` WHERE ID=? AND Password=?");
		stmt.setString(1, user.getID());
		stmt.setString(2, hash(user.getPassword()+user.getID()));
//		System.out.println(""+hash(user.getPassword()+user.getID()+""));
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			//System.out.println(rs.getString(1)+", "+rs.getString(2));
			user.setID(rs.getString(1));
			user.setPassword(rs.getString(2));
			user.setNome(rs.getString(3));
			user.setCognome(rs.getString(4));
			user.setAdmin(rs.getBoolean(5));
			return user;
			} 
		else {
			return null;
			}

		} 
	catch (SQLException e) {
		throw new RuntimeException("Elettore.ElettoreDaoImpl: "+e.toString());
		}
	}

	public void addElettore(String User, String Pass){

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ass_5?user=app&password=000&serverTimezone=UTC");
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO `ass_5`.`user` (`ID`,`Password`) VALUES (?, ?);");
			stmt.setString(1, User);
			stmt.setString(2, hash(Pass+User));

			if(stmt.executeUpdate()==1){
				System.out.println("OK!");
			}
			else {
				System.out.println("Nope!");
			}

		}
		catch (SQLException e) {
			throw new RuntimeException("Elettore.ElettoreDaoImpl: "+e.toString());
		}
	}

	private static String hash(String s){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(s.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			return sb.toString();
			} 
		catch (NoSuchAlgorithmException e){
			throw new RuntimeException("Elettore.ElettoreDaoImpl: "+e.toString());
		}
	}
}