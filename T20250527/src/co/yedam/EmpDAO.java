package co.yedam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 등록,수정,삭제,목록 기능을 구현.
 * 저장은 storage에 반영하도록 함.
 */
public class EmpDAO {
	// 사원정보를 저장하는 컬렉션.
	List<Employee> storage = new ArrayList<Employee>();
	Scanner scn = new Scanner(System.in);
	
	public void addEmp() {
		
		String empno = userMessage("사번입력");	
		String empname = userMessage("이름입력");	
		String tel = userMessage("전화번호입력");	
		String hiredate = userMessage("입사일입력");
		String salary = userMessage("급여입력");
		
		Employee employee = new Employee(empno, empname, tel, hiredate, Integer.parseInt(salary));
		
		if (storage.add(employee)) {
			System.out.println("등록을 완료하였습니다.");
		} else {
			System.out.println("등록에 실패하였습니다.");
		}
	} // addEmp
	
	public void listEmp() {
		System.out.println("사번    이름   전화번호");
		for (int i = 0; i < storage.size(); i++) {
			System.out.printf("%-6s %-4s %s\n", storage.get(i).getEmpno(), storage.get(i).getEmpname(), storage.get(i).getTel());
		}
	} // listEmp
	
	public void modifyEmp() {
		String salary = userMessage("사번 급여");
		
		String[] strary = salary.split(" ");
		
		for (int i = 0; i < storage.size(); i++) {
			if (storage.get(i).getEmpno().equals(strary[0])) {
				storage.get(i).setSalary(Integer.parseInt(strary[1]));
				System.out.println("급여를 변경하였습니다.");
				break;
			}
		}
		
	} // modifyEmp
	
	public void deleteEmp() {
		String empno = userMessage("사번");
		
		for (int i = 0; i < storage.size(); i++) {
			if (storage.get(i).getEmpno().equals(empno)) {
				storage.remove(i);
				System.out.println("삭제되었습니다.");
				break;
			}
		}
	} // deleteEmp
	
	public void selectEmp() {
		String hiredate = userMessage("입사일자");
		boolean result = false;
				
		System.out.println("사번    이름    전화번호");
		for (int i = 0; i < storage.size(); i++) {
			if (hiredate.equals(storage.get(i).getHiredate())) {
				System.out.printf("%-6s %-4s %s\n", storage.get(i).getEmpno(), storage.get(i).getEmpname(), storage.get(i).getTel());
				result = true;
			}
		}
		
		if (!result) {
			System.out.println("일치하는 사원이 없습니다.");
			return;
		}
		
	} // selectEmp
	
	String userMessage(String msg) {
		System.out.print(msg + ">> ");
		return scn.nextLine();
	} // userMessage
}
