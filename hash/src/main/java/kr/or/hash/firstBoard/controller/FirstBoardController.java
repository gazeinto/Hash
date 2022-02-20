package kr.or.hash.firstBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.hash.firstBoard.model.service.FirstBoardService;

@Controller
public class FirstBoardController {
	
	@Autowired
	private FirstBoardService fbService;
	
	@RequestMapping(value="/firstBoard/firstBoardPage.do", method = RequestMethod.GET )
	public String firstBoardPage() {
		return "firstBoard/board";
	}
	
	
}
