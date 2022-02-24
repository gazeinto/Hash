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
	
		<p>글번호 : ${map.firstBoard.boardNo}</p>
		
		<p>글이름 : ${map.firstBoard.boardTitle}</p>
	
		<p>글내용 : ${map.firstBoard.boardContent}</p>
		
		<p>조회수 : ${map.firstBoard.boardCount}</p>
		
		<p>작성일 : ${map.firstBoard.boardRegDate}</p>
	
	</div>
	
	<input type="button" value="수정하기" onclick="location.href='/firstBoard/firstBoardUpdatePage.do?boardNo=${map.firstBoard.boardNo}'">
	<input type="submit" value="삭제하기" onclick="location.href='/firstBoard/firstBoardDelete.do?boardNo=${map.firstBoard.boardNo}'">
	<input type="button" value="이전으로" onclick="location.href='/firstBoard/firstBoardListPage.do'">
	
</body>
</html>