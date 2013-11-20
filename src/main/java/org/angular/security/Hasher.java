package org.angular.security;

import java.security.MessageDigest;

/**
 * 
 * @author trgp
 *
 * Classe que se encarrega de fazer o parse da palavra usando hash encode
 * 
 */
public class Hasher {

	public static String get(String msg) {
		try {
			MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = algorithm.digest(msg.getBytes("UTF-8"));
			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest) {
			  hexString.append(String.format("%02X", 0xFF & b));
			}
			return hexString.toString();
		} catch (Exception e) {
			return msg;
		}
	}

}