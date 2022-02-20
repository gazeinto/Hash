package kr.or.hash.secondBoard.model.vo;

import java.sql.Timestamp;

public class SecondBoardPhoto {
	
	private int boardPhotoNo;
	private String boardPhotoOriginal;
	private String boardPhotoChanged;
	private String boardPhotoFilePath;
	private long boardPhotoFileSize;
	private Timestamp boardPhotoUpdateTime;
	private char boardPhotoDelYN;
	
	public SecondBoardPhoto(int boardPhotoNo, String boardPhotoOriginal, String boardPhotoChanged,
			String boardPhotoFilePath, long boardPhotoFileSize, Timestamp boardPhotoUpdateTime, char boardPhotoDelYN) {
		super();
		this.boardPhotoNo = boardPhotoNo;
		this.boardPhotoOriginal = boardPhotoOriginal;
		this.boardPhotoChanged = boardPhotoChanged;
		this.boardPhotoFilePath = boardPhotoFilePath;
		this.boardPhotoFileSize = boardPhotoFileSize;
		this.boardPhotoUpdateTime = boardPhotoUpdateTime;
		this.boardPhotoDelYN = boardPhotoDelYN;
	}

	public SecondBoardPhoto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBoardPhotoNo() {
		return boardPhotoNo;
	}

	public void setBoardPhotoNo(int boardPhotoNo) {
		this.boardPhotoNo = boardPhotoNo;
	}

	public String getBoardPhotoOriginal() {
		return boardPhotoOriginal;
	}

	public void setBoardPhotoOriginal(String boardPhotoOriginal) {
		this.boardPhotoOriginal = boardPhotoOriginal;
	}

	public String getBoardPhotoChanged() {
		return boardPhotoChanged;
	}

	public void setBoardPhotoChanged(String boardPhotoChanged) {
		this.boardPhotoChanged = boardPhotoChanged;
	}

	public String getBoardPhotoFilePath() {
		return boardPhotoFilePath;
	}

	public void setBoardPhotoFilePath(String boardPhotoFilePath) {
		this.boardPhotoFilePath = boardPhotoFilePath;
	}

	public long getBoardPhotoFileSize() {
		return boardPhotoFileSize;
	}

	public void setBoardPhotoFileSize(long boardPhotoFileSize) {
		this.boardPhotoFileSize = boardPhotoFileSize;
	}

	public Timestamp getBoardPhotoUpdateTime() {
		return boardPhotoUpdateTime;
	}

	public void setBoardPhotoUpdateTime(Timestamp boardPhotoUpdateTime) {
		this.boardPhotoUpdateTime = boardPhotoUpdateTime;
	}

	public char getBoardPhotoDelYN() {
		return boardPhotoDelYN;
	}

	public void setBoardPhotoDelYN(char boardPhotoDelYN) {
		this.boardPhotoDelYN = boardPhotoDelYN;
	}

	@Override
	public String toString() {
		return "SecondBoardPhoto [boardPhotoNo=" + boardPhotoNo + ", boardPhotoOriginal=" + boardPhotoOriginal
				+ ", boardPhotoChanged=" + boardPhotoChanged + ", boardPhotoFilePath=" + boardPhotoFilePath
				+ ", boardPhotoFileSize=" + boardPhotoFileSize + ", boardPhotoUpdateTime=" + boardPhotoUpdateTime
				+ ", boardPhotoDelYN=" + boardPhotoDelYN + "]";
	}

}
