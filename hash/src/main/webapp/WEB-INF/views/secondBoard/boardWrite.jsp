<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script src = "/resources/ckeditor/ckeditor.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#wrap{
	width: 700px;
	height: 500px;
	margin : 0 auto;
}

#title-input{
	width: 400px;
	height: 30px;
	font-size: 18px;
}
#editor4{
	width: 700px;
	height: 450px;
}
#textarea{
	padding: 15px;
}

</style>
</head>
<body>
<div id="wrap">
  <form action="/secondBoard/writeBoard.do" method="post">
  	제목 : <input type="text" id="title-input" name="boardTitle" >
   	<textarea id = "editor4" name = "boardContent"></textarea>
	<input type="button" value="목록" onclick="location.href='/secondBoard/secondBoardPage.do'">
	<input type="reset" value="초기화"/>	
	<input type="submit" value="작성완료"/>
  </form>
</div>


<script>
	CKEDITOR.replace('editor4',
			{filebrowserUploadUrl:'/secondBoard/fileUpload.do'});
</script>


</body>
</html>