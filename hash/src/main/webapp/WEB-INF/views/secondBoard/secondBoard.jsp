<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#boardDiv{
	width: 400px;
	height: 400px;
	margin : 0 auto;
}
table{
	margin : 0 auto;
	text-align: center;
}
table a{
	text-decoration: none;
	color: black;
}
</style>
</head>
<body>
<div id="boardDiv">
	<form action="/secondBoard/secondBoardPage.do" method="get">
		<select name="type">
			<option value="title">제목</option>
			<option value="content">내용</option>
			<option value="all">제목+내용</option>
		</select>
		<input type="text" name="keyword"/>
		<input type="submit" value="조회">
	</form>
	<table border="1px solid black">
		<tr>
			<th>글 번호</th>
			<th>제목</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${map.list}" var="sb">
		<tr>
			<td>${sb.boardNo }</td>
			<td><a href="/second/secondBoardSelect.do?boardNo=${sb.boardNo }">${sb.boardTitle }</a></td>
			<td>${sb.regDate }</td>
			<td>${sb.boardCount }</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="4">${map.navi }</td>
		</tr>
	</table>
	<button onclick="location.href='/secondBoard/secondBoardWrite.do'">글쓰기</button>
	<input type="button" value="메인" onclick="location.href='/'">	
</div>


</body>
</html>