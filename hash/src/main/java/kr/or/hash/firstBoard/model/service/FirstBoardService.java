package kr.or.hash.firstBoard.model.service;

import java.util.HashMap;

import kr.or.hash.firstBoard.model.vo.FirstBoard;

public interface FirstBoardService {

	HashMap<String, Object> selectFirstBoardList(HashMap<String, Object> map);

	HashMap<String, Object> firstBoardView(int boardNo);

	FirstBoard firstBoardUpdatePage(int boardNo);

	int firstBoardUpdateWrite(FirstBoard fristBoard);

	int firstBoardDelete(int boardNo);

	int firstBoardWrite(FirstBoard fristBoard);

}
