package kr.or.hash.secondBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.hash.secondBoard.model.service.SecondBoardService;

@Controller
public class SecondBoardController {

	@Autowired
	private SecondBoardService sbService;
	
	//게시판 페이지 연결
	@RequestMapping(value="/secondBoard/SecondBoardPage.do",method = RequestMethod.GET)
	public String SecondBoardPage(){
		
		sbService.selectBoard();
		
		return "secondBoard/secondBoard";
	}
	
	//
	
}
