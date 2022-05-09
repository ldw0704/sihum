package mapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import domain.ListInfoVO;
import domain.WriterVO;

public class sListMapper {

	public Collection<WriterVO> read() {
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
}


