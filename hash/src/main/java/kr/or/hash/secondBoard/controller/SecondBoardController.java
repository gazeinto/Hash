package kr.or.hash.secondBoard.controller;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.hash.secondBoard.model.service.SecondBoardService;
import kr.or.hash.secondBoard.model.vo.SecondBoard;

@Controller
public class SecondBoardController {

	@Autowired
	private SecondBoardService sbService;
	
	@Autowired
	private ServletContext context;
	
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
	public ModelAndView writeBoard(SecondBoard sb, ModelAndView mav) {
		
		int result = sbService.writeContent(sb);
	
		if(result>0) {
			mav.addObject("msg", "작성완료");
			mav.addObject("location", "/secondBoard/secondBoardPage.do");
		}else {
			mav.addObject("msg", "작성실패");
			mav.addObject("location", "/secondBoard/secondBoardPage.do");
		}
		
		mav.setViewName("commons/msg");
		
		return mav;
	}
	
	@RequestMapping(value="/secondBoard/fileUpload.do",method = RequestMethod.POST)
	public void fileUpload(HttpServletRequest request, HttpServletResponse response) throws IOException{
		


	      String uploadPath = "/resources/upload/firstBoard";
	      String uploadFilePath = context.getRealPath(uploadPath);
	      System.out.println("파일 경로 : " + uploadFilePath);

	      // 파일 사이즈 설정(50MB)
	      int uploadFileSizeLimit = 50 * 1024 * 1024;

	      // 파일 이름 인코딩 설정
	      String encType = "UTF-8";

	      // MultipartRequest 객체 생성
	      MultipartRequest multi = new MultipartRequest(request, uploadFilePath + "/temp", uploadFileSizeLimit, encType,
	            new DefaultFileRenamePolicy());

	      // 파일 이름
	      String originalFileName = multi.getFilesystemName("upload");

	      // 시간값
	      long currentTime = Calendar.getInstance().getTimeInMillis();


	      File file = new File(uploadFilePath + "\\temp\\" + originalFileName);

	      String ext = originalFileName.substring(originalFileName.lastIndexOf('.') + 1); // 파일 확장자
	      File file2 = new File(uploadFilePath + "\\" + "_" + currentTime + "." + ext);
	      file.renameTo(file2);

	      JsonObject json = new JsonObject();
	      json.addProperty("url", "/resources/upload/firstBoard/" + file2.getName());
	      json.addProperty("uploaded", 1);
	      json.addProperty("fileName", originalFileName);
	      new Gson().toJson(json, response.getWriter());


	}
	
}
