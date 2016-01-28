package com.victor.h5blog.utils;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

public class LegooUtil {

	/**
	 * get the current Date by 'yyyy-MM-dd HH:mm:ss'
	 * 
	 * @return
	 */
	public static String getCurrentTime() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		return sf.format(date);
	}

	/**
	 * determine whether the string is empty
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		boolean rtnValue = true;
		if (str == null || str.equals("") || str.equals("null")
				|| str.trim().length() == 0) {
			rtnValue = false;
		}
		return rtnValue;
	}

	/**
	 * determine whether the collection is empty
	 * 
	 * @param coll
	 * @return
	 */
	public static <T> boolean isNotEmptyCollection(Collection<T> coll) {
		boolean flag = true;
		if (coll == null) {
			flag = false;
		} else {
			if (coll.isEmpty()) {
				flag = false;
			}
		}
		return flag;
	}

	public static byte[] hex2byte(String s) {
		return hex2byte(s.getBytes(), 0, s.length() >> 1);
	}

	public static byte[] hex2byte(byte[] b, int offset, int len) {
		byte[] d = new byte[len];
		for (int i = 0; i < len * 2; i++) {
			int shift = i % 2 == 1 ? 0 : 4;
			if (offset < b.length) {
				d[i >> 1] |= Character.digit((char) b[offset + i], 16) << shift;
			}
		}
		return d;
	}
}
