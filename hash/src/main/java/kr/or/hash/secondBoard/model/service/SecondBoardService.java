package kr.or.hash.secondBoard.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.or.hash.secondBoard.model.vo.SecondBoard;

public interface SecondBoardService {

	HashMap<String, Object> selectBoard(int currentPage, HashMap<String, Object> map);

	HashMap<String, Object> secondBoardSelect(int boardNo);

}
