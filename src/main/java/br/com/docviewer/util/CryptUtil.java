package br.com.docviewer.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptUtil {

	public static Integer LENGTH_MD5_ENCRYPT = 32;
	
	public static String ConvertToMD5(String nonEncryptableText) throws NoSuchAlgorithmException{
		    MessageDigest md = MessageDigest.getInstance("MD5");
		    BigInteger hash = new BigInteger(1, md.digest(nonEncryptableText.getBytes()));
		    String s2 = hash.toString(16);
		    return s2;
	}
}
