package kr.or.hash.firstBoard.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.hash.firstBoard.model.vo.FirstBoard;


@Repository
public class FirstBoardDAO {

	@Autowired
	private SqlSessionTemplate sql;

	public ArrayList<FirstBoard> getFirstBoardList(int recordCountPerPage, HashMap<String, Object> map) {
		
		int start = (int)map.get("currentPage")*recordCountPerPage-(recordCountPerPage-1);
		int end = (int)map.get("currentPage")*recordCountPerPage;
		
		map.put("start", start);
		map.put("end",end);
		
		return new ArrayList<FirstBoard>(sql.selectList("firstBoard.firstBoardList",map));
	}

	
	public String getFirstBoardNavi(int recordCountPerPage, int naviCountPerPage, HashMap<String, Object> map) {
		
		int recordTotalCount = firstBoardTotalCount(map);
		int pageTotalCount = (int)Math.ceil(recordTotalCount/(double)recordCountPerPage);
		int currentPage = (int)map.get("currentPage");
		int startNavi = ((currentPage-1)/naviCountPerPage) *naviCountPerPage+1;
		int endNavi = startNavi+naviCountPerPage-1;
		
		if(endNavi>pageTotalCount) {
			endNavi=pageTotalCount;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<a href='/firstBoard/firstBoardListPage.do?currentPage=1&type="+map.get("type")+"&keyword="+map.get("keyword")+"' >&lt;&lt;</a>");
		sb.append("<a href='/firstBoard/firstBoardListPage.do?currentPage="+(currentPage-10)+"' id='prev' >&lt;</a>");
		
		for(int i= startNavi; i<=endNavi; i++) {
			if(i==currentPage) {
				sb.append("<a href='/firstBoard/firstBoardListPage.do?currentPage="+i+"&type="+map.get("type")+"&keyword="+map.get("keyword")+"' >"+i+"</a>");
			}else {
				sb.append("<a href='/firstBoard/firstBoardListPage.do?currentPage="+i+"&type="+map.get("type")+"&keyword="+map.get("keyword")+"' >"+i+"</a>");
			}
		}
		
		if((currentPage+10)>pageTotalCount) {
			sb.append("<a href='/firstBoard/firstBoardListPage.do?currentPage="+pageTotalCount+"&type="+map.get("type")+"&keyword="+map.get("keyword")+"' id='next' >&gt;</a>");
		}else {
			sb.append("<a href='/firstBoard/firstBoardListPage.do?currentPage="+(currentPage+10)+"&type="+map.get("type")+"&keyword="+map.get("keyword")+"' id='next' >&gt;</a>");
		}
		sb.append("<a href='/firstBoard/firstBoardListPage.do?currentPage="+pageTotalCount+"&type="+map.get("type")+"&keyword="+map.get("keyword")+"' >&gt;&gt;</a>");

		return sb.toString();
	}

	private int firstBoardTotalCount(HashMap<String, Object> map) {
		return sql.selectOne("firstBoard.selectFirstBoardListTotalCount",map);
	}


	public HashMap<String, Object> firstBoardView(int boardNo) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("firstBoardCount", sql.update("firstBoard.firstBoardCountUpdate", boardNo));
		map.put("firstBoard", sql.selectOne("firstBoard.firstBoardView", boardNo));
		
		return map;
	}


	public FirstBoard firstBoardUpdatePage(int boardNo) {
		return sql.selectOne("firstBoard.firstBoardView", boardNo);
	}


	public int firstBoardUpdateWrite(FirstBoard fristBoard) {
		return sql.update("firstBoard.firstBoardUpdate", fristBoard);
	}


	public int firstBoardDelete(int boardNo) {
		return sql.update("firstBoard.firstBoardDelete", boardNo);
	}
	
}
