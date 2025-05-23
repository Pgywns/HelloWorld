package com.yedam.api;

public class SystemExe {
	
	public static void main(String[] args) {
		
		long now = System.currentTimeMillis();
		// int 범위를 벗어나서 long으로 casting
		long year = (long)(1000 * 60 * 60 * 24) * 365;
		long day = 1000 * 60 * 60 * 24;		
		long hour = 1000 * 60 * 60;	
		long min = 1000 * 60;		
		long sec = 1000;
		
		// 현재 변수의 값을 바꾸기 때문에 제일 하위 값인 초부터 계산
		sec = (now % min) / sec;
		min = (now % hour) / min;
		hour = (now % day) / hour;
		day = (now % year) / day;
		year = (now / year);
		
		System.out.printf("%d는 %d년 %d일 %d시간 %d분 %d초 입니다.\n\n", now, year, day, hour, min, sec);
		
		long start = System.nanoTime();
		int sum = 0;
		for (int i = 0; i < 100000000; i++) {
			sum += i;
		}
		
		long end = System.nanoTime();
		System.out.printf("합계 %d, 걸린시간 %d\n", sum, (end - start));
		
	} // main

}
