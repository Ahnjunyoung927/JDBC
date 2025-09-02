package com.kh.cardMember.model.vo;

import java.sql.Date;
import java.util.Objects;

public class CardMember {
	
	private int memberNo;
	private String name;
	private String residentNo;
	private String phone;
	private String grade;
	private Date enrollDate;
	
	public CardMember() {
		super();
	}

	public CardMember(int memberNo, String name, String residentNo, String phone, String grade, Date enrollDate) {
		super();
		this.memberNo = memberNo;
		this.name = name;
		this.residentNo = residentNo;
		this.phone = phone;
		this.grade = grade;
		this.enrollDate = enrollDate;
	}

	public CardMember(String name, String residentNo, String phone, String grade) {
		super();
		this.name = name;
		this.residentNo = residentNo;
		this.phone = phone;
		this.grade = grade;
	}
	
	

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResidentNo() {
		return residentNo;
	}

	public void setResidentNo(String residentNo) {
		this.residentNo = residentNo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(enrollDate, grade, memberNo, name, phone, residentNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CardMember other = (CardMember) obj;
		return Objects.equals(enrollDate, other.enrollDate) && Objects.equals(grade, other.grade)
				&& memberNo == other.memberNo && Objects.equals(name, other.name) && Objects.equals(phone, other.phone)
				&& Objects.equals(residentNo, other.residentNo);
	}

	@Override
	public String toString() {
		return "CardMember [memberNo=" + memberNo + ", name=" + name + ", residentNo=" + residentNo + ", phone=" + phone
				+ ", grade=" + grade + ", enrollDate=" + enrollDate + "]";
	}
	
	
	
	

}
