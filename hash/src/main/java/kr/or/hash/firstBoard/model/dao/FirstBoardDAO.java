package kr.or.hash.firstBoard.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FirstBoardDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
}
