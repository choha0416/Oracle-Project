package mis;
import java.util.*;
import java.sql.*;
public class Delete {
	Scanner scanner = new Scanner(System.in);
	Board bd = new Board();
	MainMenu mm = new MainMenu();
	public void deleteB() {
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
			System.out.print("삭제할 게시글의 번호를 선택하세요: ");		
			String dlno = scanner.nextLine();
			
			String sql1 = "DELETE FROM boards2 WHERE bno=?";
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1, dlno);		
			pstmt1.executeUpdate();
			System.out.println("삭제 완료하였습니다");
			System.out.println(bd);
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
