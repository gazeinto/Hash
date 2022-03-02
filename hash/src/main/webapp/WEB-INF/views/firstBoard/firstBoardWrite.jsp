<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/firstBoard/firstBoardWrite.do" method="post">
	
		제목 : <input type="text" name="boardTitle"/> <br><br>
		
		내용 : <textarea name="boardContent"></textarea> <br><br>
		
		<input type="submit" value="작성완료">
		<input type="button" value="이전으로" onclick="history.back(-1);">
		
	</form>

</body>
</html>