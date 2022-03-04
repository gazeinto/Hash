<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#wrap{
	width: 500px;
	height: 500px;
	margin : 0 auto;
}
#title{
	width: 100%;
	height: 100px;
}
#title>p{
	text-align: center;
	margin-top: 0px;
	margin-bottom: 0px;
}
#content{
	width: 100%;
	height: 340px;
}
#textarea{
	padding: 15px;
}
</style>
</head>
<body>
<div id="wrap">
	<div id="title">
		<p>제목 : ${map.sb.boardTitle }</p>
		<p>글 번호 : ${map.sb.boardNo }</p>
		<p>조회수 : ${map.sb.boardCount }</p>
		<p>작성일 : ${map.sb.regDate }</p>
	</div>
	<div id="content">
		<p>${map.sb.boardContent }</p>
	</div>
	<input type="button" value="목록" onclick="location.href='/secondBoard/secondBoardPage.do'">
</div>
</body>
</html>