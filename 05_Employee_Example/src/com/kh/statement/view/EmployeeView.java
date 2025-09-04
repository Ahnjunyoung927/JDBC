package com.kh.statement.view;

import java.util.List;
import java.util.Scanner;

import com.kh.statement.controller.EmployeeController;
import com.kh.statement.model.vo.Employee;

public class EmployeeView {
	private Scanner sc = new Scanner(System.in);
	private EmployeeController ec = new EmployeeController();

	public void mainMenu() {
		while (true) {
			System.out.println("================== 사원 관리 서비스 ==================");
			System.out.println("1. 전체 사원 조회");
			System.out.println("2. 부서명별 조회");
			System.out.println("3. 직급별 조회");
			System.out.println("4. 개별사원 상세조회");
			System.out.println("5. 임금 상위 사원 조회(5명)");
			System.out.println("6. 임금 하위 사원 조회(5명)");
			System.out.println("7. 사원 추가");
			System.out.println("8. 사원 정보 수정");
			System.out.println("9. 퇴사 사원 입력");
			System.out.print("원하시는 메뉴를 입력해주세요 : ");
			int mainMenu = sc.nextInt();
			sc.nextLine();

			switch (mainMenu) {
			case 1:
				selectAll();
				break;
			case 2:
				selectByDept();
				break;
			case 3:
				selectByJob();
				break;
			case 4:
				selectByEmpId();
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}
	}

	private void selectAll() {
		System.out.println(
				"=========================================< 전체 사원 정보 조회 >=============================================");

		List<Employee> employees = ec.selectAll();

		for (Employee emp : employees) {
			System.out.println("사원번호 : " + emp.getEmpId() + ", 사원명 : " + emp.getEmpName() + ", 급여 : " + emp.getSalary()
					+ ", 부서명 : " + emp.getDeptCode() + ", 직급명 : " + emp.getJobCode());
			System.out.println(
					"=========================================================================================================");
			System.out.println();
		}
	}

	private void selectByDept() {
		System.out.println(
				"=========================================< 부서별 사원 정보 조회 >=============================================");
		System.out.print("조회할 부서명을 입력해주세요 : ");
		String dept = sc.nextLine();
		System.out.println("==========================================================================================================");
		
		List<Employee> employees = ec.selectByDept(dept);
		
		for (Employee emp : employees) {
			System.out.println("사원번호 : " + emp.getEmpId() + ", 사원명 : " + emp.getEmpName() + ", 급여 : " + emp.getSalary()
					+ ", 부서명 : " + emp.getDeptCode() + ", 직급명 : " + emp.getJobCode());
			System.out.println(
					"==========================================================================================================");
			System.out.println();
		}
	}
	
	private void selectByJob() {
		System.out.println(
				"=========================================< 직급별 사원 정보 조회 >=============================================");
		System.out.print("조회할 직급명을 입력해주세요 : ");
		String job = sc.nextLine();
		System.out.println("==========================================================================================================");
		
		List<Employee> employees = ec.selectByJob(job);
		
		for (Employee emp : employees) {
			System.out.println("사원번호 : " + emp.getEmpId() + ", 사원명 : " + emp.getEmpName() + ", 급여 : " + emp.getSalary()
					+ ", 부서명 : " + emp.getDeptCode() + ", 직급명 : " + emp.getJobCode());
			System.out.println(
					"==========================================================================================================");
			System.out.println();
		}
	}
	
	private void selectById() {
		System.out.println();
		System.out.println("============================================< 개별 사원 조회 >=============================================");
		System.out.print("조회할 사원의 사원번호를 입력해주세요 : ");
		String empId = sc.nextLine();
		
		Employee employee = ec.selectById(empId);
		
		if(employee != null) {
			System.out.println("사원번호 : " + );
		} else {
			System.out.println("입력하신 사원번호에 해당하는 사원이 없습니다.");
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
