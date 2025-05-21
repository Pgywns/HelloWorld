package com.yedam.inheritance;

/*
 	CellPhone 을 상속
*/
public class SmartPhone extends CellPhone {
	int channel;
	
	// 부모 클래스에서 생성자가 정의되었으므로, 자식 클래스에서 부모 클래스의 생성자를 호출해야 함
	/* 부모 클래스에서 기본 생성자가 없고 매개변수를 받는 생성자가 있기 때문에 상속받는 자식클래스에서도
	   매개 값을 받는 생성자로 호출해줘야 함 */
	public SmartPhone(String model, String color, int channel) {
		super(model, color); // 부모 클래스의 생성자를 호출
		this.channel = channel;
	}
	
	void watch() {
		System.out.println(channel + "을 시청합니다.");
	}
	
	// 부모클래스의 기능을 자식클래스에서 재정의(overriding)
	@Override
	void powerOn() {
		System.out.println("전원을 켭니다. (๐॔˃̶ᗜ˂̶๐॓)");
	}
	
	@Override
	void powerOff() {
		System.out.println("전원을 끕니다. ┑(￣Д ￣)┍");
	}
	
	// 부모 클래스인 CellPhone보다 상위에 있는 Object 클래스의 기능을 재정의
	// CellPhone에서 오버라이딩을 했기 때문에 CellPhone 클래스의 toString을 의미
	// CellPhone에서 오버라이딩을 하지 않았으면 Object 클래스의 toString을 의미함
	@Override
	public String toString() {
		// 부모클래스의 메소드를 호출
		return super.toString(); // super는 부모
	}
	
}