package mis;

import java.util.*;
import java.sql.*;
import java.io.*;
public class Update {
	Scanner scanner = new Scanner(System.in);
	Board bd = new Board();
	MainMenu mm = new MainMenu();
	public void updateB() {
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
			
			System.out.print("수정할 게시글의 번호를 선택하세요: ");		
			String upno = scanner.nextLine();
			
			System.out.print("수정할 제목: ");	
			String btitles = scanner.nextLine();
			bd.setBtitle(btitles);
			System.out.println("수정할 내용:");
			String bcontents = scanner.nextLine();
			bd.setBcontent(bcontents);
			System.out.println("글쓴이");
			String bwriters = scanner.nextLine();
			bd.setBwriter(bwriters);
			
			String sql1 = new StringBuilder() 
				.append("UPDATE boards2 SET ")
				.append("btitle=?, ")
				.append("bcontent=?, ")
				.append("bwriter=? ")
				.append("WHERE bno=?")
				.toString();
				
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1,bd.getBtitle());
			pstmt1.setString(2,bd.getBcontent());
			pstmt1.setString(3,bd.getBwriter());
			pstmt1.setString(4,upno);
			pstmt1.executeUpdate();
			
		
			System.out.println("수정 완료하였습니다");
			//System.out.println(bd); 수정한 내용은 잘 나오나 bno가 잘못출력됨
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
