package mis;
import java.util.*;
import java.sql.*;
import java.io.*;
public class UserInsert {
	Scanner scanner = new Scanner(System.in);
	MainMenu mm = new MainMenu();
	User us = new User();
	public void insertU() {
		Connection conn = null;
		System.out.println("아이디를 입력해 주세요");
		String userids = scanner.nextLine();
		us.setUserId(userids);
		
		System.out.println("이름을 입력해 주세요");
		String usernames = scanner.nextLine();
		us.setUserName(usernames);
		
		System.out.println("비밀번호를 입력해 주세요");
		String userpasswords = scanner.nextLine();
		us.setUserPassword(userpasswords);
		
		System.out.println("나이를 입력해 주세요");
		int userages = Integer.parseInt(scanner.nextLine());
		us.setUserAge(userages);
		
		System.out.println("이메밀 입력해 주세요");
		String useremails = scanner.nextLine();
		us.setUserEmail(useremails);
		
		System.out.println("등록이 완료되었습니다");
		System.out.println();
		System.out.println("\t\t"+"아이디:"+us.getUserId());
		System.out.println("\t\t"+"이름:"+us.getUserName());
		System.out.println("\t\t"+"이메일:"+us.getUserEmail());
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
					"INSERT INTO user2(userid, username, userpassword, userage, useremail) "+
							"VALUES(?, ?, ?, ?, ?)";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1,us.getUserId());
					pstmt.setString(2,us.getUserName());
					pstmt.setString(3,us.getUserPassword());
					pstmt.setInt(4,us.getUserAge());
					pstmt.setString(5,us.getUserEmail());
					
					
					
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