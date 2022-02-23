<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FirstBoard</title>
</head>
<body>

	<h1>게시판페이지</h1>
	
	<form action="/firstBoard/firstBoardListPage.do" method="get">
		
		<select name="type" class="search_select">
			<option value="title">제목</option>
			<option value="content">내용</option>
			<option value="all">제목+내용</option>
		</select>
		
		<input type="text" name="keyword" class="searchkeyword" placeholder="검색어 입력"/>

		<button class="test">글 검색</button>
		
	</form>
	
	<table class="table">
		<thead>
		   <tr>
		     <th scope="col">글 번호</th>
		     <th scope="col">글 제목</th>
		     <th scope="col">작성일</th>
		     <th scope="col">조회수</th>
		   </tr>
		 </thead>
		
		<c:forEach items="${map.list}" var="board">
			<tr class="view" onclick="location.href='/'">
				<th>${board.boardNo}</th>
				<td>${board.boardTitle}</td>
				<td>${board.boardRegDate}</td>
				<td>${board.boardCount}</td>
			</tr>
		</c:forEach>
	</table>
	
	<div class="pageNavi">
		${map.pageNavi}
	</div>
	
	<div class="buttonform">
		<input type="submit" value="글쓰기" onclick="location.href='/'">
		<input type="button" value="홈으로" onclick="location.href='/'">
	</div>
	
	<script>
	
	$(function() {
		var currentPage = ${currentPage};
		if (currentPage < 11) {
			$('#prev').removeAttr('href');
			$('#prev').unbind('mouseenter mouseleave');
		}
	});
		
	</script>	
		
</body>
</html>