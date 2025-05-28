package co.yedam;

import java.util.Date;

/*
 * 사원번호, 이름, 전화번호, 입사일자, 급여 항목을 필드로 선언하고
 * 필요한 메소드를 정의하세요.
 */
public class Employee {
	private String empno;
	private String empname;
	private String tel;
	private String hiredate;
	private int salary;
	
	
	public Employee(String empno, String empname, String tel, String hiredate, int salary) {
		
		this.empno = empno;
		this.empname = empname;
		this.tel = tel;
		this.hiredate = hiredate;
		this.salary = salary;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}
