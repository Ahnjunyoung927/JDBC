package com.kh.board.model.dto;

import java.sql.Date;

public class BoardDTO {
	private int boardNo;           
	private String boardTitle;     
	private String boardContent;  
	private String boardWritter;   
	private Date createDate;       
	private String deleteStatus;   
	// 기본생성자, boardNo, createDate, deleteStatus 세 개 뺀 생성자, 모든 필드 생성자
	// getter, setter
	
	public BoardDTO() {
		super();
	}
	public BoardDTO(String boardTitle, String boardContent, String boardWritter) {
		super();
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWritter = boardWritter;
	}
	public BoardDTO(int boardNo, String boardTitle, String boardContent, String boardWritter, Date createDate,
			String deleteStatus) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWritter = boardWritter;
		this.createDate = createDate;
		this.deleteStatus = deleteStatus;
	}
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardWritter() {
		return boardWritter;
	}
	public void setBoardWritter(String boardWritter) {
		this.boardWritter = boardWritter;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getDeleteStatus() {
		return deleteStatus;
	}
	public void setDeleteStatus(String deleteStatus) {
		this.deleteStatus = deleteStatus;
	}
	
	
	
}
