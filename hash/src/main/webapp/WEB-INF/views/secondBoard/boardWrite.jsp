<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <script src="https://cdn.ckeditor.com/ckeditor5/29.1.0/classic/ckeditor.js"></script>
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
	height: 50px;
}
#title-input{
	width: 400px;
	height: 30px;
	font-size: 18px;
}
#classic{
	width: 100%;
	height: 380px;
}
#textarea{
	padding: 15px;
}
.ck.ck-editor {
    max-width: 500px;
}
.ck-editor__editable {
	min-height: 300px;
}
</style>
</head>
<body>
<div id="wrap">
  <form action="/secondBoard/writeBoard.do" method="post">
	<div id="title">
		제목 : <input type="text" id="title-input" name="boardTitle" >
	</div>
   	<div id="classic">
        <textarea rows="5" cols="10" name="boardContent"></textarea>
	</div>
	<input type="button" value="목록" onclick="location.href='/secondBoard/secondBoardPage.do'">
	<input type="reset" value="초기화"/>	
	<input type="submit" value="작성완료"/>
  </form>
</div>


<script>
   ClassicEditor
       .create( document.querySelector( '#classic' ))
       .catch( error => {
           console.error( error );
       } );
</script>

</body>
</html>