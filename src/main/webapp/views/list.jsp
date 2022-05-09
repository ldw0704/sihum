<%@page import="java.sql.DriverManager"%>
<%@page import="domain.WriterVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String url = "jdbc:mysql://localhost:3306/smart?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
String user = "root";
String password = "smart";

Connection conn = null;
PreparedStatement stmt = null;
ResultSet rs = null;

ArrayList<WriterVO> list = new ArrayList<WriterVO>();

try {
	StringBuffer qry = new StringBuffer();
	qry.append(" SELECT * FROM board ");			
	
				
	String sql = qry.toString();
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection(url, user, password);			
	
	stmt = conn.prepareStatement(sql);
				
	rs = stmt.executeQuery();
	
	WriterVO vo = null;
	
	while(rs.next()) {
		vo = new WriterVO();
		
		vo.setNum(rs.getInt("num"));				
		vo.setTitle(rs.getString("title"));
		vo.setContent(rs.getString("content"));
		vo.setWriter(rs.getString("writer"));	
		vo.setWriteDate(rs.getDate("writedate"));
		
		list.add(vo);				
	}
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} finally {
	try {
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table style="border : 1px solid black;">
		<tr>
			<td width="100px">글번호</td>
			<td width="300px">제목</td>
			<td width="100px">작성자</td>
			<td width="100px">작성일</td>
		</tr>
		
		
<%for(WriterVO vo : list){
	
%>		
		<tr>
			<td><%=vo.getNum() %></td>
			<td><%=vo.getTitle() %></td>
			<td><%=vo.getWriter() %></td>
			<td><%=vo.getWriteDate() %></td>
		</tr>
<%
}
%>		
	</table>


</body>
</html>