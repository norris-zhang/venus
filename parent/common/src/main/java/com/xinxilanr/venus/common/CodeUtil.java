/**
 * 
 */
package com.xinxilanr.venus.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author norris
 *
 */
public class CodeUtil {

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

	
}
