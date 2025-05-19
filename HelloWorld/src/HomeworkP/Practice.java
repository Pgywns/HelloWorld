package HomeworkP;

import java.util.Scanner;

public class Practice {
	public static void main(String[] args) {

	} // main

	public static void name1() {
		// 숫자 세 개 입력 받아서 입력받은 애들을 더해서 합계, 평균 구하기
		int sum = 0;
		int avg = 0;
		int max = 0;

		Scanner scanner = new Scanner(System.in);
		System.out.println("값을 입력하세요");
		int num1 = Integer.parseInt(scanner.nextLine());
		
		System.out.println("다른값을 입력하세요");
		int num2 = Integer.parseInt(scanner.nextLine());

		System.out.println("값을 하나 더 입력하세여");
		int num3 = Integer.parseInt(scanner.nextLine());

		if ((num1 < 3) || (num2 < 3) || (num3 < 3)) {
			System.out.println("3보다 작은값이 있습니다");
		} else {
//	       num1 + num2 = sum; // 수학적 의미
			sum = num1 + num2 + num3; // 프로그래밍적 의미
			avg = sum / 3;
			System.out.printf("합계: %d,\n 평균: %d", sum, avg);
		}

	} // end of name;

	public static void name2() {
		// 배열
		// 정수값을 담을 값 5개
		int[] name = new int[5];
		// 배열 이름은 name2, 형태는 문자열 크기가 정해지지 않음
		String[] name2 = null; // 크키가 없는 배열은 = null;
		name2 = new String[10];

		int[] name3 = { 1, 2, 3, 4, 5 }; // 변수 값선언
		name3[3] = 10;
		for (int i = 0; i < name3.length; i++) {
			System.out.println(name3[i]);
			name3[i] = 5;

		}
		for (int i = 0; i < name3.length; i++) {
			System.out.println(name3[i]);

		}
		int[] name4; // 크기는 없고 배열만 선언.
		name4 = new int[] { 1, 2, 3 }; // 값을 넣어서 크기설정하면 값도 들어가고 크기도 들어감

		// 배열 이름은 std, 크기는 3, 배열에 학생 3명을 입력해서 넣기
		String[] std = new String[3];
		Scanner scn = new Scanner(System.in);
		for (int i = 0; i < std.length; i++) {
			System.out.println("학생이름을 입력해주세요");
//	         String list  = scn.nextLine();
			std[i] = scn.nextLine();
		}
		for (int i = 0; i < std.length; i++) {
			System.out.println(std[i]);
		}
		// 숫자를 입력받고
		System.out.println("숫자를 입력하세요");
		int num1 = Integer.parseInt(scn.nextLine());

		if ((num1 == 1) || (num1 == 2) || (num1 == 3)) {
			System.out.println(std[num1 - 1]);
		} else {
			System.out.println("목록에 없습니다");
		}

	} // end of test2

	// while 문
	public static void name3() {
		boolean run = true;

		// 값을 입력 받아서 종료 입력하면 종료됨뜨게하기
		Scanner scn = new Scanner(System.in);
		while (run) {
			System.out.println("값을 입력하세요");
			String num = scn.nextLine();
			if (num.equals("종료")) { // equals 문자열비교함수 (문자=문자)
				System.out.println("종료되었습니다");
				run = false; // = break; 동일 의미 boolean타입 둘다 사용가능.
			}
		}

	} // end of name3.

	// case
	public static void name4() {
		Scanner scn = new Scanner(System.in);
		boolean run = true;

		while (run) {
			System.out.println("번호를 입력하세요 1,2,3,4");
			int num = Integer.parseInt(scn.nextLine());
			switch (num) {
			case 1:
				System.out.println("1번입니다");
				break;
			case 2:
				System.out.println("2번입니다");
				break;
			case 3:
				System.out.println("3번입니다");
				break;
			case 4:
				System.out.println("종료");
				run = false; // run이 false로 바뀜
				break; // break 걸리면서 스위치케이스문 종료 => while문은 false 이기때문에 반복 종료

			default:
				System.out.println("1~4까지만 입력해주세요");
			}
		}

	}// end of name4
}
