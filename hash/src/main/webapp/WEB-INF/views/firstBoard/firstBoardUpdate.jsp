<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="/firstBoard/firstBoardUpdate.do" method="post">
	
		제목 : <input type="text" name="boardTitle" value="${firstBoard.boardTitle}"/> <br><br>
		
		내용 : <textarea name="boardContent">${firstBoard.boardContent}</textarea> <br><br>
		
		<input type="hidden" value="${firstBoard.boardNo }" name="boardNo">
		
		<input type="submit" value="수정하기">
		<input type="button" value="이전으로" onclick="history.back(-1);">
		
	</form>
	
</body>
</html>