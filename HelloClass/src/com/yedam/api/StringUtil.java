package com.yedam.api;

public class StringUtil {

	public static String getGender(String sample) {
		String str = sample.substring(sample.length() - 7, sample.length());
		
		char gen = str.charAt(0);

		if ((gen == '1') || (gen == '3')) {
			return "남성";
		}
		
		return "여성";
	}
	
	public static String getExtName(String fileName) {
		int str = fileName.indexOf(".");
		String result = fileName.substring(str + 1, fileName.length());
		
		return result;
	}
	
}
