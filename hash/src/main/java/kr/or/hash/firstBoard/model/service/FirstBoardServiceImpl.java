package kr.or.hash.firstBoard.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.hash.firstBoard.model.dao.FirstBoardDAO;
import kr.or.hash.firstBoard.model.vo.FirstBoard;

@Service
public class FirstBoardServiceImpl implements FirstBoardService {

	@Autowired
	private FirstBoardDAO fbDAO;

	@Override
	public HashMap<String, Object> selectFirstBoardList(HashMap<String, Object> map) {
		
		int recordCountPerPage = 10;
		ArrayList<FirstBoard> list = fbDAO.getFirstBoardList(recordCountPerPage,map);
		
		int naviCountPerPage = 10;
		String pageNavi = fbDAO.getFirstBoardNavi(recordCountPerPage,naviCountPerPage,map);
		
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("list", list);
		returnMap.put("pageNavi",pageNavi);
		
		return returnMap;
	}

	@Override
	public FirstBoard firstBoardView(int boardNo) {
		return fbDAO.firstBoardView(boardNo);
	}

	@Override
	public FirstBoard firstBoardUpdatePage(int boardNo) {
		return fbDAO.firstBoardUpdatePage(boardNo);
	}

	@Override
	public int firstBoardUpdateWrite(FirstBoard fristBoard) {
		return fbDAO.firstBoardUpdateWrite(fristBoard);
	}
	
}
