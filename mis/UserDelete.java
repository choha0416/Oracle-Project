package mis;
import java.util.*;
import java.sql.*;
public class UserDelete {
	Scanner scanner = new Scanner(System.in);
	User us = new User();
	MainMenu mm = new MainMenu();
	public void userDl() {
		Connection conn = null;

		try {

			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe",
					"system",
					"oracle"
			);
			System.out.print("삭제할 아이디를 선택하세요: ");		
			String usdl = scanner.nextLine();
			us.setUserId(usdl);
			System.out.print("비밀번호를 입력하세요: ");		
			String usdl2 = scanner.nextLine();
			us.setUserPassword(usdl2);
			String sql = "DELETE FROM user2 WHERE userid=? AND userpassword=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, us.getUserId());
			pstmt.setString(2, us.getUserPassword());
			pstmt.executeUpdate();
			
			pstmt.close();		
					
					pstmt.close();
					System.out.println();
					System.out.println();
					mm.mainMn();
		}  catch(SQLException e) {
			e.printStackTrace();
		} 
	}
}