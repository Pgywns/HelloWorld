package HomeworkP;

import java.util.Calendar;

public class Practice2 {
	
	public static void main(String[] args) {
		
		String[] samples = { "9503061234567"//
				, "990603 2345678"//
				, "030502-3456789" };
		
		String[] samples2 = {"gywns@naver.com",
							"didididi@google.com",
							"qmqmqm@daum.net"};
		
		String samples3 = "a3b4c5";
		
		
		System.out.println(birth(samples[1]));
		
		System.out.println(email(samples2[0]));
		
		System.out.printf("%d살입니다.\n", age(samples[0]));
		
		str(samples3);
	} // main
	
	public static String birth(String sample) {
		String year = sample.substring(0, 2);
		String month = sample.substring(2, 4);
		String day = sample.substring(4, 6);
		
		String str = year + "년 " + month + "월 " + day + "일";
		
		if (year.substring(0, 1).equals("0")) {
			return "20" + str;
		}
		
		return "19" + str;
	}
	
	public static String email(String sample) {
		return sample.substring(0, sample.indexOf("@"));
	}
	
	public static int age(String sample) {
		Calendar now = Calendar.getInstance();
		
		String year = sample.substring(0, 2);
		int age = 0;
		
		if (year.substring(0, 1).equals("0")) {
			 age = Integer.parseInt("20" + year);
		} else {
			 age = Integer.parseInt("19" + year);
		}
		
		return now.get(Calendar.YEAR) - age;
	}
	
	public static void str(String sample) {
		
		String result = "";
		int num = 0;
		
		for (int i = 0; i < sample.length(); i++) {
			result = sample.substring(0, 2);
			num = Integer.parseInt(result.substring(1, 2));		
		}
		
		for (int j = 0; j < num; j++) {
			System.out.print(result.substring(0, 1));			
		}
		
	}
	
}
