<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="">
	<table>
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" id="title"/></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textArea rows="4" cols="30" name="content" id="content"></textArea></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="writer" id="writer"/></td>
		</tr>
	</table>
	
	<button>글쓰기</button>
</form>
</body>
</html>