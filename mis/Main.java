package mis;
import java.util.*;
import java.sql.*;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainMenu mm = new MainMenu();
		mm.mainMn();
		//Create ct = new Create();
		//ct.createB();
		Connection conn = null;
		try {
			//jdbc드라이버 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//연결
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe",
					"system",
					"oracle"
			);
			//System.out.println("연결성공");
			String sql =""+
					"SELECT bno, bwriter, bcontent, btitle, bdate "+
					"FROM boards2";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBtitle(rs.getString("btitle"));
				board.setBdate(rs.getDate("bdate"));
			}
			
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn !=null) {
				try {
					//연결끊기
					conn.close();
					//System.out.println("연결끊기");
				} catch(SQLException e) {}
			}
		}
	}

}
