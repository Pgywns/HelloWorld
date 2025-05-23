package com.yedam.api;

public class StringExe {

	public static void main(String[] args) {
		String str1 = new String("Hello");
		str1 = new String(new byte[] { 72, 101, 108, 108, 111 });
		
		System.out.println(str1.charAt(1));
		System.out.println(str1.indexOf("s"));

	} // main

}
