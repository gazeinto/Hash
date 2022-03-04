package kr.or.hash.secondBoard.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.hash.secondBoard.model.service.SecondBoardService;
import kr.or.hash.secondBoard.model.vo.SecondBoard;

@Controller
public class SecondBoardController {

	@Autowired
	private SecondBoardService sbService;
	
	//게시판 페이지 연결
	@RequestMapping(value="/secondBoard/secondBoardPage.do",method = RequestMethod.GET)
	public ModelAndView SecondBoardPage(ModelAndView mav,
										@RequestParam(required = false, defaultValue = "1") int currentPage,
										@RequestParam(required = false, defaultValue = "") String type,
										@RequestParam(required = false, defaultValue = "default") String keyword){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("keyword", keyword);
		map.put("type", type);
		
		map = sbService.selectBoard(currentPage, map);
		
		mav.addObject("map",map);
		mav.setViewName("secondBoard/secondBoard");
		
		return mav;
	}
	
	//해당 게시글로 이동
	@RequestMapping(value="/second/secondBoardSelect.do",method = RequestMethod.GET)
	public ModelAndView secondBoardSelect(@RequestParam int boardNo,
									ModelAndView mav) {
		
		HashMap<String, Object> map = sbService.secondBoardSelect(boardNo);
		
		mav.addObject("map",map);
		mav.setViewName("secondBoard/selectBoard");
		
		return mav;
	}
	
	//글쓰기
	@RequestMapping(value="/secondBoard/secondBoardWrite.do")
	public String secondBoardWrite() {
	
		return "secondBoard/boardWrite";
	}
	
	
	@RequestMapping(value="/secondBoard/writeBoard.do", method = RequestMethod.POST)
	public void writeBoard(@RequestParam String boardContent) {
		
		System.out.println(boardContent);
	}
}
