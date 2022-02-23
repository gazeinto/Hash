<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글보기</title>
</head>
<body>
	
	<div>
	
		<p>글번호 : ${firstBoard.boardNo}</p>
		
		<p>글이름 : ${firstBoard.boardTitle}</p>
	
		<p>글내용 : ${firstBoard.boardContent}</p>
		
		<p>작성일 : ${firstBoard.boardRegDate}</p>
	
	</div>
	
	<input type="button" value="수정하기" onclick="location.href='/firstBoard/firstBoardUpdatePage.do?boardNo=${firstBoard.boardNo}'">
	<input type="button" value="이전으로" onclick="location.href='/firstBoard/firstBoardListPage.do'">
	
</body>
</html>