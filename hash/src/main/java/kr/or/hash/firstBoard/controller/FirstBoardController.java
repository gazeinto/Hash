package kr.or.hash.firstBoard.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.hash.firstBoard.model.service.FirstBoardService;

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
	
}
