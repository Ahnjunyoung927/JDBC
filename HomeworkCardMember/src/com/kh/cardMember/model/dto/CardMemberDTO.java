package com.kh.cardMember.model.dto;

public class CardMemberDTO {
	private String name;
	private String phone;
	private String newPhone;
	
	public CardMemberDTO() {
		super();
	}
	public CardMemberDTO(String name, String phone, String newPhone) {
		super();
		this.name = name;
		this.phone = phone;
		this.newPhone = newPhone;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNewPhone() {
		return newPhone;
	}
	public void setNewPhone(String newPhone) {
		this.newPhone = newPhone;
	}
	
	@Override
	public String toString() {
		return "CardMemberDTO [name=" + name + ", phone=" + phone + ", newPhone=" + newPhone + "]";
	}
	
	
	

}
