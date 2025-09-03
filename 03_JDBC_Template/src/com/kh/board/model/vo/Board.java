package com.kh.board.model.vo;

import java.sql.Date;
import java.util.Objects;

public class Board {
	private int boardNo;           // PRIMARY KEY
	private String boardTitle;     // NOT NULL
	private String boardContent;   // NOT NULL
	private String boardWriter;   // FOREIGN KEY(USERNO)
	private Date createDate;       // DEFAULT SYSDATE
	private String deleteStatus;   // DEFAULT N
	
	// 모든 필드에 대한 매개변수생성자
	// getter
	// equals, hashCode
	public Board(int boardNo, String boardTitle, String boardContent, String boardWritter, Date createDate,
			String deleteStatus) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
		this.createDate = createDate;
		this.deleteStatus = deleteStatus;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public String getDeleteStatus() {
		return deleteStatus;
	}

	@Override
	public int hashCode() {
		return Objects.hash(boardContent, boardNo, boardTitle, boardWriter, createDate, deleteStatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		return Objects.equals(boardContent, other.boardContent) && boardNo == other.boardNo
				&& Objects.equals(boardTitle, other.boardTitle) && Objects.equals(boardWriter, other.boardWriter)
				&& Objects.equals(createDate, other.createDate) && Objects.equals(deleteStatus, other.deleteStatus);
	}
	
	
	
	
	
}
