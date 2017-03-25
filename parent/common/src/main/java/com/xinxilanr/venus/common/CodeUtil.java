/**
 * 
 */
package com.xinxilanr.venus.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Random;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author norris
 *
 */
public class CodeUtil {
	private static final char[] LETTER_NUMBER = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

	public static String sha256(String src) {
		try {
			return sha256(src, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String sha256(String src, String charsetName) throws UnsupportedEncodingException {
		MessageDigest sha256Digest = DigestUtils.getSha256Digest();
		byte[] digest = sha256Digest.digest(src.getBytes(charsetName));
		String hexString = Hex.encodeHexString(digest);
		return hexString;
	}

	public static String randomString(int length) {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int nextInt = random.nextInt(LETTER_NUMBER.length);
			sb.append(LETTER_NUMBER[nextInt]);
		}
		return sb.toString();
	}

}
