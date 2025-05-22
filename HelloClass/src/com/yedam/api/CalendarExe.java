package com.yedam.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 *	Calendar: 날짜, 시간 관련
 *	Date: 날짜, 시간 
 */

public class CalendarExe {
	public static void main(String[] args) {
		makeCalendar(2025, 5);
	} // main

	public static void makeCalendar(int year, int month) {
		Calendar now = Calendar.getInstance();
		now.set(year, month - 1, 1);
		
		System.out.printf("%13d년 %02d월\n", year, month);
		System.out.println("============================");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
		System.out.println("============================");
		
		for (int i = 1; i < now.get(Calendar.DAY_OF_WEEK); i++) {
			System.out.printf("%4s", " ");
		}
		
		for (int i = 1; i <= now.getActualMaximum(Calendar.DATE); i++) {
			System.out.printf("%4d", i);
			
			if ((i + now.get(Calendar.DAY_OF_WEEK) - 1) % 7 == 0) {
				System.out.println(" ");
			}
		}
	}
	
	public static void date() {
		Date today = new Date();
		System.out.println(today.toString());
		// 생성자의 매개값으로 포맷지정
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년-MM월-dd일 HH시mm분ss초");
		String timeStr = sdf.format(today);
		System.out.println(timeStr);
		
		try {
			today = sdf.parse("2025-08-01 09:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println(today);
	} // date
	
	public static void cal() {
		// Calendar 클래스
		Calendar now = Calendar.getInstance();
		now.set(2025, 0, 1);
		now.set(Calendar.YEAR, 2024);

		// 요일
		int dayOfWeek = now.get(Calendar.DAY_OF_WEEK); // 요일 정보를 숫자로 표현 일요일이 1
		String day = "";
		switch (dayOfWeek) {
		case 1:
			System.out.println("일요일");
			day = "일";
			break;
		case 2:
			System.out.println("월요일");
			day = "월";
			break;
		case 3:
			System.out.println("화요일");
			day = "화";
			break;
		case 4:
			System.out.println("수요일");
			day = "수";
			break;
		case 5:
			System.out.println("목요일");
			day = "목";
			break;
		case 6:
			System.out.println("금요일");
			day = "금";
			break;
		case 7:
			System.out.println("토요일");
			day = "토";
			break;
		}

		System.out.printf("%d년-%d월-%d일 %s요일 %d일\n",
						now.get(Calendar.YEAR),
						now.get(Calendar.MONTH) + 1, // 1월이 0이라 현재 월은 +1을 해줘야 함
						now.get(Calendar.DATE),
						day,
						now.getActualMaximum(Calendar.DATE) // 현재 달의 마지막 날짜
		);
	} // cal
}
