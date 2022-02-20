package kr.or.hash.firstBoard.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.hash.firstBoard.model.dao.FirstBoardDAO;

@Service
public class FirstBoardServiceImpl implements FirstBoardService {

	@Autowired
	private FirstBoardDAO fbDAO;
	
}
