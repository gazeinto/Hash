package kr.or.hash.secondBoard.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SecondBoardDAO {

	@Autowired
	private SqlSessionTemplate sql;

	public void selectBoard() {

		sql.selectList("secondBoard.selectBoard");
	}
	
}
