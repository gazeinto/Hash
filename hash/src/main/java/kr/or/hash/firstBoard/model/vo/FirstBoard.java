package kr.or.hash.firstBoard.model.vo;

import java.sql.Date;

public class FirstBoard {

	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private Date boardRegDate;
	private int boardCount;
	private char boardEndYN;
	private int boardPhotoNo;
	
	
	public FirstBoard() {
		super();
		// TODO Auto-generated constructor stub
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


	public Date getBoardRegDate() {
		return boardRegDate;
	}


	public void setBoardRegDate(Date boardRegDate) {
		this.boardRegDate = boardRegDate;
	}


	public int getBoardCount() {
		return boardCount;
	}


	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}


	public char getBoardEndYN() {
		return boardEndYN;
	}


	public void setBoardEndYN(char boardEndYN) {
		this.boardEndYN = boardEndYN;
	}


	public int getBoardPhotoNo() {
		return boardPhotoNo;
	}


	public void setBoardPhotoNo(int boardPhotoNo) {
		this.boardPhotoNo = boardPhotoNo;
	}


	public FirstBoard(int boardNo, String boardTitle, String boardContent, Date boardRegDate, int boardCount,
			char boardEndYN, int boardPhotoNo) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardRegDate = boardRegDate;
		this.boardCount = boardCount;
		this.boardEndYN = boardEndYN;
		this.boardPhotoNo = boardPhotoNo;
	}


	@Override
	public String toString() {
		return "FirstBoard [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardRegDate=" + boardRegDate + ", boardCount=" + boardCount + ", boardEndYN=" + boardEndYN
				+ ", boardPhotoNo=" + boardPhotoNo + "]";
	}
	
	
	
	
}
