package mis;
import java.util.*;
import java.sql.*;
public class List {
	Scanner scanner = new Scanner(System.in);
	Board bd = new Board();
	MainMenu mm = new MainMenu();
	public void listB() {
		Connection conn = null;
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("----------------------------------------게시물 목록---------------------------------");
		System.out.printf("\t%-6s%-16s%-16s%-10s%-10s\n", "no","제목","내용","글쓴이","작성일");
		System.out.println();
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
