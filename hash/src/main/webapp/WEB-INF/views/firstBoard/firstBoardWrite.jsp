<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src = "${path}/ckeditor/ckeditor.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/firstBoard/firstBoardWrite.do" method="post">
	
		제목 : <input type="text" name="boardTitle"/> <br><br>
		
		내용 : <textarea name="boardContent" name="ckeditor" id="ckeditor"></textarea> <br><br>
		
		<input type="submit" value="작성완료">
		<input type="button" value="이전으로" onclick="history.back(-1);">
		
	</form>
	
	<script>
		$(function(){
		    
		    CKEDITOR.replace( 'ckeditor', {//해당 이름으로 된 textarea에 에디터를 적용
		        width:'100%',
		        height:'400px',
		        filebrowserImageUploadUrl: '/community/imageUpload' //여기 경로로 파일을 전달하여 업로드 시킨다.
		    });
		    
		    
		    CKEDITOR.on('dialogDefinition', function( ev ){
		        var dialogName = ev.data.name;
		        var dialogDefinition = ev.data.definition;
		     
		        switch (dialogName) {
		            case 'image': //Image Properties dialog
		                //dialogDefinition.removeContents('info');
		                dialogDefinition.removeContents('Link');
		                dialogDefinition.removeContents('advanced');
		                break;
		        }
		    });
		    
		});
	</script>
	

</body>
</html>