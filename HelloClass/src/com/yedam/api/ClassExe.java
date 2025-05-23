package com.yedam.api;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassExe {
	
	public static void main(String[] args) {
		
		try {
			Class cls = Class.forName("com.yedam.api.Member");
			Member member = new Member();
			cls = member.getClass();
			System.out.println(cls.getName());
			
			Field[] fieldAry = cls.getDeclaredFields(); // 클래스의 필드를 배열로 반환
			for (Field field : fieldAry) {
				System.out.println(field.getName());
			}
			
			Method[] methodAry = cls.getDeclaredMethods(); // 클래스의 메소드를 배열로 반환
			for (Method method : methodAry) {
				System.out.println(method.getName());
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	} // main
	
}
