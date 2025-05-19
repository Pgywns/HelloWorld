package com.yedam.ref;

public class ArrayExe2 {
	
	public static void main(String[] args) {
		int[][] intAry = { { 17, 22, 31, 55 }, { 28, 38, 12 } };
		intAry[0][2] = 44;
		
		for (int outer = 0; outer < intAry.length; outer++) {
			for (int inner = 0; inner < intAry[outer].length; inner++) {
				System.out.printf("intAry[%d][%d] => %d\n", outer, inner, intAry[outer][inner]);
			}
		}
		
		System.out.println("-----------------------");
		
		int[][] ary2 = new int[3][4];
		int sum = 0;
		
		for (int o = 0; o < ary2.length; o++) {
			for (int i = 0; i < ary2[o].length; i++) {
				 ary2[o][i] = (int)(Math.random() * 100) + 1;
				 if (o == 1) {
					 sum += ary2[o][i]; 
				 }
				 System.out.printf("ary2[%d][%d] => %d\n", o, i, ary2[o][i]);
			}
		}
		
		System.out.printf("ary2[1] 요소의 합 => %d", sum);
		
	} // main
}
