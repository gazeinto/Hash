package kr.or.hash.firstBoard.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.hash.firstBoard.model.service.FirstBoardService;
import kr.or.hash.firstBoard.model.vo.FirstBoard;

@Controller
public class FirstBoardController {
	
	@Autowired
	private FirstBoardService fbService;
	
	//게시판페이지로의 접근하여 리스트출력
	@RequestMapping(value="/firstBoard/firstBoardListPage.do", method = RequestMethod.GET )
	public ModelAndView firstBoardPage(ModelAndView mav,
			@RequestParam(required = false,defaultValue = "1") int currentPage,
			@RequestParam(required = false, defaultValue = "") String keyword,
			@RequestParam(required = false, defaultValue = "default") String type) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("currentPage", currentPage);
		map.put("keyword", keyword);
		map.put("type", type);
		
		HashMap<String, Object> returnMap = fbService.selectFirstBoardList(map);
		
		returnMap.put("keyword", keyword);
		returnMap.put("type", type);
		
		mav.addObject("map",returnMap);
		mav.addObject("currentPage",currentPage);
		mav.setViewName("firstBoard/firstBoard");
		
		return mav;
		
	}
	
	//글 조회
	@RequestMapping(value="/firstBoard/firstBoardView.do", method=RequestMethod.GET)
	public ModelAndView firstBoardViewPage(@RequestParam int boardNo,
			@RequestParam(required = false, defaultValue= "1") int currentPage,
			@RequestParam(required = false, defaultValue= "") String keyword,
			@RequestParam(required = false, defaultValue= "default") String type,
			ModelAndView mav) {

		FirstBoard firstBoard = fbService.firstBoardView(boardNo);
		
		mav.addObject("currentPage", currentPage);
		mav.addObject("type", type);
		mav.addObject("keyword", keyword);
		mav.addObject("firstBoard", firstBoard);
		mav.setViewName("firstBoard/firstBoardView");
		
		return mav;
	}
	
	//글 수정 페이지로 이동
	@RequestMapping(value="/firstBoard/firstBoardUpdatePage.do", method = RequestMethod.GET)
	public ModelAndView firstBoardUpdatePage(ModelAndView mav,
			@RequestParam int boardNo) {			
		
		FirstBoard firstBoard = fbService.firstBoardUpdatePage(boardNo);
		
		mav.addObject("firstBoard", firstBoard);
		mav.setViewName("firstBoard/firstBoardUpdate");
		
		return mav;
	};
	
	//글 수정
	@RequestMapping(value="/firstBoard/firstBoardUpdate.do", method = RequestMethod.POST)
	public ModelAndView firstBoardUpdate(FirstBoard fristBoard,
			ModelAndView mav) {
		
		int result = fbService.firstBoardUpdateWrite(fristBoard);
		
		if(result > 0) {
			mav.addObject("location", "/firstBoard/firstBoardView.do?boardNo="+fristBoard.getBoardNo());
			mav.addObject("msg", "수정성공");
		}else {
			mav.addObject("location", "/firstBoard/firstBoardUpdatePage.do");
			mav.addObject("msg", "수정실패");
		}
		mav.setViewName("commons/msg");
		return mav;
	};
	
	//글 삭제
	
}
