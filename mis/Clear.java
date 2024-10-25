package mis;
import java.util.*;
import java.sql.*;
public class Clear {
	Scanner scanner = new Scanner(System.in);
	Board bd = new Board();
	MainMenu mm = new MainMenu();
	public void clearB() {
		Connection conn = null;

		try {
			//jdbc드라이버 등록
			//Class.forName("oracle.jdbc.OracleDriver");
			//연결
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe",
					"system",
					"oracle"
			);
			String sql = ""+
			"SELECT bno, btitle, bcontent, bwriter, bdate "+
			"FROM boards2 ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
					while(rs.next()) {
						bd.setBno(rs.getInt("bno"));
						bd.setBtitle(rs.getString("btitle"));
						bd.setBcontent(rs.getString("bcontent"));
						bd.setBwriter(rs.getString("bwriter"));
						bd.setBdate(rs.getDate("bdate"));
						System.out.println(bd);
					}
			
			
			String sql1 = "TRUNCATE TABLE boards2";
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
		
			pstmt1.executeUpdate();
			System.out.println("삭제 완료하였습니다");
			
			pstmt1.close();		
					rs.close();
					pstmt.close();
					System.out.println();
					System.out.println();
					mm.mainMn();
		}  catch(SQLException e) {
			e.printStackTrace();
		} 
	}
}
