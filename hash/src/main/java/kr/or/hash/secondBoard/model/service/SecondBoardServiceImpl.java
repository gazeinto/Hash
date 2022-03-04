package kr.or.hash.secondBoard.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.hash.secondBoard.model.dao.SecondBoardDAO;
import kr.or.hash.secondBoard.model.vo.SecondBoard;

@Service
public class SecondBoardServiceImpl implements SecondBoardService{

	@Autowired
	private SecondBoardDAO sbDAO;

	@Override
	public HashMap<String, Object> selectBoard(int currentPage, HashMap<String, Object> map) {
		
		int recordCountPerPage=5;
		
	    ArrayList<SecondBoard> list = sbDAO.selectBoard(recordCountPerPage, currentPage, map);
	    
	    int naviCountPerPage = 10;
	    
	    String navi = sbDAO.getPageNavi(recordCountPerPage, currentPage, map ,naviCountPerPage);
	    
	    map.put("list", list);
	    map.put("navi", navi);
	    
	    return map;
	    
		
	}

	@Override
	public HashMap<String, Object> secondBoardSelect(int boardNo) {

		return sbDAO.secondBoardSelect(boardNo);
		
	}
}
