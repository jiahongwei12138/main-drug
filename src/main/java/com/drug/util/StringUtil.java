package com.drug.util;

public class StringUtil {

	public static boolean isEmpty(String inStr) {
		return inStr==null || "".equals(inStr);//
	}
	public static boolean isNotEmpty(String inStr) {
		return !isEmpty(inStr);
	}

}
