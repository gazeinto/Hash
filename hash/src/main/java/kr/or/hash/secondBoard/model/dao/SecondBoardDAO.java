package kr.or.hash.secondBoard.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.hash.secondBoard.model.vo.SecondBoard;

@Repository
public class SecondBoardDAO {

	@Autowired
	private SqlSessionTemplate sql;

	public ArrayList<SecondBoard> selectBoard(int recordCountPerPage, int currentPage, HashMap<String, Object> map) {

		int start = currentPage*recordCountPerPage-(recordCountPerPage-1);
		int end = currentPage * recordCountPerPage;
		
		map.put("start", start);
		map.put("end", end);
		
		return new ArrayList<SecondBoard>(sql.selectList("secondBoard.selectBoard", map));
		
	}

	public String getPageNavi(int recordCountPerPage, int currentPage, HashMap<String, Object> map,
			int naviCountPerPage) {

		int recordTotalCount = totalCount(map);
		int pageTotalCount = (int)Math.ceil(recordTotalCount/(double)recordCountPerPage);
		int startNavi = ((currentPage-1)/naviCountPerPage) *naviCountPerPage+1;
		int endNavi = startNavi+naviCountPerPage-1;
		
		if(endNavi>pageTotalCount) {
			endNavi=pageTotalCount;
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("<a href='/secondBoard/secondBoardPage.do?currentPage=1&type="+map.get("type")+"&keyword="+map.get("keyword")+"' >&lt;&lt;</a>");
		sb.append("<a href='/secondBoard/secondBoardPage.do?currentPage="+(currentPage-10)+"' id='prev' >&lt;</a>");
		
		for(int i= startNavi; i<=endNavi; i++) {
			if(i==currentPage) {
				sb.append("<a href='/secondBoard/secondBoardPage.do?currentPage="+i+"&type="+map.get("type")+"&keyword="+map.get("keyword")+"' >"+i+"</a>");
			}else {
				sb.append("<a href='/secondBoard/secondBoardPage.do?currentPage="+i+"&type="+map.get("type")+"&keyword="+map.get("keyword")+"' >"+i+"</a>");
			}
		}
		
		if((currentPage+10)>pageTotalCount) {
			sb.append("<a href='/secondBoard/secondBoardPage.do?currentPage="+pageTotalCount+"&type="+map.get("type")+"&keyword="+map.get("keyword")+"' id='next' >&gt;</a>");
		}else {
			sb.append("<a href='/secondBoard/secondBoardPage.do?currentPage="+(currentPage+10)+"&type="+map.get("type")+"&keyword="+map.get("keyword")+"' id='next' >&gt;</a>");
		}
		sb.append("<a href='/secondBoard/secondBoardPage.do?currentPage="+pageTotalCount+"&type="+map.get("type")+"&keyword="+map.get("keyword")+"' >&gt;&gt;</a>");
		
		return sb.toString();
		
	}
	
	public int totalCount(HashMap<String, Object> map) {
		
		return sql.selectOne("secondBoard.totalCount",map);
	}

	public HashMap<String, Object> secondBoardSelect(int boardNo) {

		int result = sql.update("secondBoard.updateBoardCount",boardNo);
		SecondBoard sb =  sql.selectOne("secondBoard.secondBoardSelect",boardNo);
		
		HashMap<String,Object> map = new HashMap<String, Object>();
		
		map.put("result", result);
		map.put("sb", sb);
		
		return map;
	}
}
