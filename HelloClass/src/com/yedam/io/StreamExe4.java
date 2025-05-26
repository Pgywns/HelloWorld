package com.yedam.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * 객체 입출력 스트림
 * 기본타입 - 참조타입
 * int num = 10;
 * Member member = new Member();
 * 직렬화(Serialization) : 객체 -> 기본
 * Serializable 인터페이스 구현 클래스
 */

class Product implements Serializable {
	String prodCode;

	public Product(String prodCode) {
		this.prodCode = prodCode;
	}
}

public class StreamExe4 {

	public static void main(String[] args) {
		
		try {
			InputStream is = new FileInputStream("c:/temp/object.db");
			ObjectInputStream ois = new ObjectInputStream(is);
			
			List<Product> list = (List<Product>) ois.readObject(); // ClassNotFoundException
			for (Product product : list) {
				System.out.println("상품코드: " + product.prodCode);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("end of prog");

	} // main

	static void serial() {
		List<Product> list = new ArrayList<>();
		list.add(new Product("P001"));
		list.add(new Product("P002"));

		try {
			// 기본스트림
			OutputStream os = new FileOutputStream("c:/temp/object.db");

			// 객체 입출력 보조 스트림
			ObjectOutputStream oos = new ObjectOutputStream(os);

			oos.writeObject(list);
			oos.close();
			os.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
