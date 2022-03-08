<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script src="/resources/ckeditor/ckeditor.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 	<form action="/firstBoard/firstBoardWrite.do" method="post" enctype="multipart/form-data">
	
		제목 : <input type="text" name="boardTitle"/> <br><br>
		
		<textarea name="boardContent" id="ckeditor"></textarea> <br><br>
		
		<input type="submit" value="작성완료">	
		<input type="button" value="이전으로" onclick="history.back(-1);">
		
	</form>
	
	<script> 
		var ckeditor_config = {
			resize_enaleb : false,
			enterMode : CKEDITOR.ENTER_BR,
			shiftEnterMode : CKEDITOR.ENTER_P,
			filebrowserUploadUrl : "/ckUpload.do"
		};
	</script>
	
	<script>
		CKEDITOR.replace( 'ckeditor', ckeditor_config);
	</script>
	

</body>
</html>