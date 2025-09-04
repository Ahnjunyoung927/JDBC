package com.kh.statement.model.vo;

import java.sql.Date;
import java.util.Objects;

/*
EMPLOYEE테이블로 JDBC프로젝트 만들기!
구현 해야하는 기능 목록
1. 회원 전체 조회(사번, 사원명, 급여, 부서명, 직급명)
-> JOB, DEPARTMENT JOIN
2. 부서명을 입력받아 부서가 동일한 사원 조회(총무부 입력시 총무부인 사원들만 조회되도록)
-> JOB JOIN
3. 직급명을 입력받아 직급이 동일한 사원 조회(과장 입력시 과장인 사원들만 조회되도록)
-> DEPARTMENT JOIN
4. 사원 상세 조회(사번을 입력받아서 모든 컬럼 값 조회)
5. 급여가 높은 상위 다섯명 조회
-> ROWNUM 또는 OFFSET 사용
6. 급여가 낮은 하위 다섯명 조회
-> ROWNUM 또는 OFFSET 사용
7. 사원 추가 기능
8. 사원 정보 수정(사번을 입력받아 급여, 직급, 부서 수정)
9. 사원 퇴사 기능(사번을 입력받아 퇴사 여부, 퇴사일 수정)
모든 SQL문은 xml파일에서 입력받아 사용
DBMS접속정보는 properties파일에서 입력받아 사용
*/
public class Employee {
	private String empId;
	private String empName;
	private String empNo;
	private String email;
	private String phone;
	private String deptCode;
	private String jobCode;
	private String salLevel;
	private int salary;
	private double bonus;
	private String managerId;
	private Date hireDate;
	private Date entDate;
	private String entYn;
	public Employee() {
		super();
	}
	
	
	public Employee(String empId, String empName, int salary, String deptCode, String jobCode) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.deptCode = deptCode;
		this.jobCode = jobCode;
		this.salary = salary;
	}


	public Employee(String empId, String empName, String empNo, String email, String phone, String deptCode,
			String jobCode, String salLevel, int salary, double bonus, String managerId, Date hireDate, Date entDate,
			String entYn) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empNo = empNo;
		this.email = email;
		this.phone = phone;
		this.deptCode = deptCode;
		this.jobCode = jobCode;
		this.salLevel = salLevel;
		this.salary = salary;
		this.bonus = bonus;
		this.managerId = managerId;
		this.hireDate = hireDate;
		this.entDate = entDate;
		this.entYn = entYn;
	}
	public String getEmpId() {
		return empId;
	}
	public String getEmpName() {
		return empName;
	}
	public String getEmpNo() {
		return empNo;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public String getJobCode() {
		return jobCode;
	}
	public String getSalLevel() {
		return salLevel;
	}
	public int getSalary() {
		return salary;
	}
	public double getBonus() {
		return bonus;
	}
	public String getManagerId() {
		return managerId;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public Date getEntDate() {
		return entDate;
	}
	public String getEntYn() {
		return entYn;
	}
	@Override
	public int hashCode() {
		return Objects.hash(bonus, deptCode, email, empId, empName, empNo, entDate, entYn, hireDate, jobCode, managerId,
				phone, salLevel, salary);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Double.doubleToLongBits(bonus) == Double.doubleToLongBits(other.bonus)
				&& Objects.equals(deptCode, other.deptCode) && Objects.equals(email, other.email)
				&& empId == other.empId && Objects.equals(empName, other.empName) && Objects.equals(empNo, other.empNo)
				&& Objects.equals(entDate, other.entDate) && Objects.equals(entYn, other.entYn)
				&& Objects.equals(hireDate, other.hireDate) && Objects.equals(jobCode, other.jobCode)
				&& Objects.equals(managerId, other.managerId) && Objects.equals(phone, other.phone)
				&& Objects.equals(salLevel, other.salLevel) && salary == other.salary;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empNo=" + empNo + ", email=" + email
				+ ", phone=" + phone + ", deptCode=" + deptCode + ", jobCode=" + jobCode + ", salLevel=" + salLevel
				+ ", salary=" + salary + ", bonus=" + bonus + ", managerId=" + managerId + ", hireDate=" + hireDate
				+ ", entDate=" + entDate + ", entYn=" + entYn + "]";
	}
	
	
	

}
