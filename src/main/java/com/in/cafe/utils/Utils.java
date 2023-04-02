package com.in.cafe.utils;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.web.multipart.MultipartFile;

public class Utils {
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	/**
	 * @param <T>
	 * @param objects
	 * @return
	 */
	public static <T> boolean isEmpty(List<T> objects) {
		if (objects != null && objects.size() > 0)
			return false;
		return true;
	}

	/**
	 * @param <T>
	 * @param objects
	 * @return
	 */
	public static <T> Boolean isEmpty(T objects) {
		if (objects != null && !"".equals(objects))
			return false;
		return true;
	}

	/**
	 * @param str
	 * @return
	 */
	public static Boolean isEmpty(String str) {
		if (str != null && str.length() > 0)
			return false;
		return true;
	}
	
	public static <K, V> K getKey(Map<K, V> map, V value) {
		for (K key : map.keySet()) {
			if (value.equals(map.get(key))) {
				return key;
			}
		}
		return null;
	}

	public static String createOtp(int len) throws NoSuchAlgorithmException {

		// Using numeric values
		String numbers = "123456789";

		Random random = SecureRandom.getInstanceStrong();

		char[] otp = new char[len];

		for (int i = 0; i < len; i++) {
			otp[i] = numbers.charAt(random.nextInt(numbers.length()));
		}
		return String.valueOf(otp);
	}
    public static File multipartToFile(MultipartFile multipart, String fileName) throws IllegalStateException, IOException {
        File convFile = new File(System.getProperty("java.io.tmpdir")+File.separator+fileName);
        multipart.transferTo(convFile);
        return convFile;
    }

	public static String createEncryptedName(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
		int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
		builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
}
