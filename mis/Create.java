package mis;
import java.util.*;
import java.sql.*;
public class Create {
	Scanner scanner = new Scanner(System.in);
	MainMenu mm = new MainMenu();
	Board bd = new Board();
	public void createB() {
		Connection conn = null;
		System.out.println("제목을 입력해 주세요");
		String btitles = scanner.nextLine();
		bd.setBtitle(btitles);
		System.out.println("내용을 입력해 주세요");
		String bcontents = scanner.nextLine();
		bd.setBcontent(bcontents);
		System.out.println("글쓴이를 입력해 주세요");
		String bwriters = scanner.nextLine();
		bd.setBwriter(bwriters);
		
		System.out.println("작성이 완료되었습니다");
		System.out.println("\t\t"+"제목:"+bd.getBtitle());
		System.out.println("내용:"+bd.getBcontent());
		System.out.println("\t\t"+"글쓴이:"+bd.getBwriter());
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
					"INSERT INTO boards2(bno, btitle, bcontent, bwriter) "+
							"VALUES(SEQ_BNO.NEXTVAL, ?, ?, ?)";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1,bd.getBtitle());
					pstmt.setString(2,bd.getBcontent());
					pstmt.setString(3,bd.getBwriter());
					
					
					
					pstmt.executeUpdate();
					
					pstmt.close();
					System.out.println();
					System.out.println();
					mm.mainMn();
		}  catch(SQLException e) {
			e.printStackTrace();
		} 
	}
}
