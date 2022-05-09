package mapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WriterMapper {

	public void insert(String title, String content, String writer) {
		
		String url = "jdbc:mysql://localhost:3306/smart?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "smart";
		
		Connection conn = null;
		PreparedStatement stmt = null;		
		
		try {
			StringBuffer qry = new StringBuffer();
			qry.append(" INSERT INTO smart.board (title, content, writer, writedate) ");
			qry.append(" VALUES (?, ?, ?, now()) ");
						
			String sql = qry.toString();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, title);
			stmt.setString(2, content);
			stmt.setString(3, writer);
			
			stmt.executeUpdate();						
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {			
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	
	}
}
