package kr.or.hash.secondBoard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.hash.secondBoard.dao.SecondBoardDAO;

@Service
public class SecondBoardServiceImpl implements SecondBoardService{

	@Autowired
	private SecondBoardDAO sbDAO;

	@Override
	public void selectBoard() {
		
		sbDAO.selectBoard();
		
	}
}
