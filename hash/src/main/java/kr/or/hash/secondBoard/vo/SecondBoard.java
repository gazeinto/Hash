package kr.or.hash.secondBoard.vo;

import java.sql.Date;

public class SecondBoard {

	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private Date regDate;
	private int boardCount;
	private char endYN;
	private int boardPhotoNo;
	
	public SecondBoard(int boardNo, String boardTitle, String boardContent, Date regDate, int boardCount, char endYN,
			int boardPhotoNo) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.regDate = regDate;
		this.boardCount = boardCount;
		this.endYN = endYN;
		this.boardPhotoNo = boardPhotoNo;
	}

	public SecondBoard() {
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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}

	public char getEndYN() {
		return endYN;
	}

	public void setEndYN(char endYN) {
		this.endYN = endYN;
	}

	public int getBoardPhotoNo() {
		return boardPhotoNo;
	}

	public void setBoardPhotoNo(int boardPhotoNo) {
		this.boardPhotoNo = boardPhotoNo;
	}

	@Override
	public String toString() {
		return "SecondBoard [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", regDate=" + regDate + ", boardCount=" + boardCount + ", endYN=" + endYN + ", boardPhotoNo="
				+ boardPhotoNo + "]";
	}
	
	
	
}
