package Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash{
	
	public static String hash(String s) {
	
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
			throw new RuntimeException("Admin.adminDaoImpl: "+e.toString());
		}
	}
}