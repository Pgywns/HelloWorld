package com.yedam;

import com.yedam.member.Member;

public class CalculatorExe {
	public static void main(String[] args) {
		Calculator cal = new Calculator(); // 인스턴스 생성
		int num1 = 5;
		String str = "┑(￣Д ￣)┍ ㄟ( ▔, ▔ )ㄏ";
		String result = cal.printStar(num1, str);
		System.out.println(result);

		double sum = cal.add(num1, 10.5);

		int[] numAry = { 10, 20, 30 };
		sum = cal.add(numAry);

		System.out.println(sum);

		// Member[] 중에서 point가 큰 회원을 반환
		Member[] members = { new Member("user01", "홍길동", "1111", 1000),
				new Member("user02", "김민규", "2222", 2000),
				new Member("user03", "손흥민", "3333", 2700),
				new Member("user04", "이강인", "4444", 1900) };

		Member member = cal.getMaxPoint(members);
		
		member.showInfo();
			
	}
}
