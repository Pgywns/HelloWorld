package com.yedam.collection;

import java.util.ArrayList;
import java.util.List;

import com.yedam.api.Member;

/*
 * 인덱스를 사용해서 객체를 관리
 * 순서를 가지고 중복된 값 가능 
 */

public class ListExe {

	public static void main(String[] args) {
		
		// 10 ~ 100점 점수를 임의의 값으로 생성 (정수 10개)
//		List<Integer> numbers = new ArrayList<Integer>();
		List<Student> numbers = new ArrayList<Student>();
		// 10개 점수의 합, 평균 출력
		int sum = 0;
		double avg = 0;
		
		for (int i = 0; i < 10; i++) {
			Student st = new Student(1000 + i, (int)(Math.random() * 91) + 10);
			numbers.add(st);
			sum += numbers.get(i).getScore();
//			numbers.add((int)(Math.random() * 91) + 10);
//			sum += numbers.get(i);
			
		}

		avg = (sum * 1.0) / numbers.size();
		
		System.out.printf("합은: %d, 평균은: %.2f", sum, avg);
		
	} // main

	public static void exe2() {

		List<Member> members = new ArrayList<>();
		Member member = new Member("김길동", 20);

		members.add(new Member("홍길동", 10));
		members.add(member);
		members.add(new Member("이길동", 30));

		// 삭제
//		members.remove(member); // 주소값으로 삭제

		String search = "김길동";
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).memberName.equals(search)) {
				members.remove(i);
			}
		}

		for (int i = 0; i < members.size(); i++) {
			System.out.println(members.get(i).toString()); // toString은 객체를 출력하면 자동으로 호출되는 메서드라서 쓰지 않아도 자동으로 메서드를 호출 함
		}

	} // exe2

	public static void exe1() {

		// 인터페이스 -구현클래스
//		List list = new ArrayList(); 이렇게 선언해도 무방함
		// 추가하는 데이터 타입이 object 타입이라 다양한 자료형을 담을 수 있지만 출력 때 문제가 생기므로 배열을 선언할 때 자료형을 정해줌
		ArrayList<String> list = new ArrayList<String>();
		list.add("10"); // 값을 순서대로 추가
		list.add(new String("Hello"));

		list.add(1, "20"); // 특정 인덱스에 값을 추가할 수 있음

		// 삭제
		list.remove(0); // 특정 인덱스를 삭제

		// 변경
		list.set(1, "World"); // 특정 인덱스의 값을 변경

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i)); // 특정 인덱스 값을 가져오기
		}

//		for (String item : list) {
//			String result = item;
//			System.out.println(item);
//		}

	} // exe1

}
