package com.yedam.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StreamExe2 {

	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("c:/temp/writer.txt"));
			while (true) {
				String data = scanner.nextLine();
				String[] strAry = data.split(" ");
				System.out.println(strAry[0] + ", " + strAry[1]);
			}
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			scanner.close();
		}

		System.out.println("end of prog");
	} // main

	public static void reader() {
		// char 기반의 입력스트림
		try {
			Reader reader = new FileReader("c:/temp/writer.txt");
			while (true) {
				int data = reader.read();
				if (data == -1) {
					break;
				}
				System.out.print(data);
			}
			reader.close();
			System.out.println();

		} catch (IOException e) {
			e.printStackTrace();
		}

	} // reader

	public static void writer() {
		// char 기반의 출력스트림
		try {

			Writer wr = new FileWriter("c:/temp/writer.txt");
			wr.write('A');
			wr.write('B');
			wr.write('C');
			wr.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	} // writer

}
