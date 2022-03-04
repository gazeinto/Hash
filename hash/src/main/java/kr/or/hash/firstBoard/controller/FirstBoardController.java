package kr.or.hash.firstBoard.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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

		HashMap<String, Object> map = fbService.firstBoardView(boardNo);
		
		mav.addObject("currentPage", currentPage);
		mav.addObject("type", type);
		mav.addObject("keyword", keyword);
		mav.addObject("map", map);
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
	@RequestMapping(value = "/firstBoard/firstBoardDelete.do", method = RequestMethod.GET)
	public ModelAndView firstBoardDelete(ModelAndView mav,
			@RequestParam int boardNo) {
		
		int result = fbService.firstBoardDelete(boardNo);
		
		if(result > 0) {
			mav.addObject("msg", "삭제완료" );
			mav.addObject("location", "/firstBoard/firstBoardListPage.do");
		}else {
			mav.addObject("msg", "삭제실패" );
			mav.addObject("location", "/firstBoard/firstBoardDelete.do?boardNo="+boardNo);
		}
		
		mav.setViewName("commons/msg");
		return mav;
	}
	
	//글 작성 페이지로 이동
	@RequestMapping(value = "/firstBoard/firstBoardWritePage.do", method = RequestMethod.GET)
	public String firstBoardWritePage() {
		return "firstBoard/firstBoardWrite";
	}
	
	//글 작성
	@RequestMapping(value = "/firstBoard/firstBoardWrite.do", method = RequestMethod.POST)
	public ModelAndView firstBoardWrite(FirstBoard fristBoard,
			ModelAndView mav) {
		
		int result = fbService.firstBoardWrite(fristBoard);
		
		if(result > 0) {
			mav.addObject("msg", "작성완료" );
			mav.addObject("location", "/firstBoard/firstBoardListPage.do");
		}else {
			mav.addObject("msg", "작성실패" );
			mav.addObject("location", "/firstBoard/firstBoardListPage.do");
		}
		
		mav.setViewName("commons/msg");
		return mav;
	}

	
	@Autowired
	private ServletContext context;
	
	
	@RequestMapping(value = "/imgUpload.do", method = RequestMethod.POST)
	public void communityFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
	  
		String uploadPath = "/resources/upload/firstBoard";
		String uploadFilePath = context.getRealPath(uploadPath); System.out.println("파일 경로 : " +uploadFilePath);
		  
		// 파일 사이즈 설정(50MB)
		int uploadFileSizeLimit = 50 * 1024 * 1024;
		  
		// 파일 이름 인코딩 설정
		String encType = "UTF-8";
		  
		// MultipartRequest 객체 생성
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath + "/temp", uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
		  
		// 파일 이름
		String originalFileName = multi.getFilesystemName("upload");
		  
		// 시간값
		long currentTime = Calendar.getInstance().getTimeInMillis();
		  
		// 폴더에 저장될 파일 이름 지정
		File file = new File(uploadFilePath + "\\temp\\" + originalFileName);
		  
		String ext = originalFileName.substring(originalFileName.lastIndexOf('.') + 1);
		// 파일 확장
		File file2 = new File(uploadFilePath + "\\" + currentTime + "." + ext);
		file.renameTo(file2);
		  
		JsonObject json = new JsonObject();
		json.addProperty("url", "/resources/upload/firstBoard/" + file2.getName());
		json.addProperty("uploaded", 1);
		json.addProperty("fileName", originalFileName);
		new Gson().toJson(json, response.getWriter());
	  
	}
	 
	/*
	@RequestMapping("/imgUpload.do")
	@ResponseBody
	public void imageUpload(HttpServletRequest request, HttpServletResponse response, @RequestParam MultipartFile upload) throws Exception { 
	response.setCharacterEncoding("utf-8");
	 response.setContentType("text/html;charset=utf-8"); 
	String fileName=upload.getOriginalFilename(); 
	Date date = new Date(); 
	SimpleDateFormat imsi = new SimpleDateFormat("yyMMddHHmmssZ"); 
	fileName = imsi.format(date)+"_"+fileName; 
	byte[] bytes = upload.getBytes(); 
	String uploadPath = request.getSession().getServletContext().getRealPath("/")+"/resources/ckeditor/images/"; 

	OutputStream outStr = new FileOutputStream(new File(uploadPath + fileName)); 
	outStr.write(bytes); 
	//String callback=request.getParameter("CKEditorFuncNum"); 
	PrintWriter out=response.getWriter(); 
	String fileUrl=request.getContextPath()+"/resources/ckeditor/images/"+fileName;
	//out.println("window.parent.CKEDITOR.tools.callFunction("+callback+",'"+fileUrl+"','이미지가 업로드되었습니다.')"+""); 
	out.println("{\"filename\" : \""+fileName+"\", \"uploaded\" : 1, \"url\":\""+fileUrl+"\"}"); 
	out.flush();
	outStr.close(); 
	}*/
}
