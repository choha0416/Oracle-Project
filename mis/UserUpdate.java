package mis;
import java.util.*;
import java.sql.*;
import java.io.*;

public class UserUpdate {
	
	
	Scanner scanner = new Scanner(System.in);
	User us = new User();
	MainMenu mm = new MainMenu();
	public void userUp() {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe",
					"system",
					"oracle"
			);
			System.out.print("정보를 수정할 아이디를 입력하세요: ");		
			String usid = scanner.nextLine();
			
			System.out.print("수정할 이름: ");	
			String usernameu = scanner.nextLine();
			us.setUserName(usernameu);
			
			System.out.println("수정할 비밀번호:");
			String userpasswords = scanner.nextLine();
			us.setUserPassword(userpasswords);
			
			System.out.println("수정할 나이");
			int userages = Integer.parseInt(scanner.nextLine());
			us.setUserAge(userages);
			
			System.out.println("수정할 이메일");
			String useremails = scanner.nextLine();
			us.setUserEmail(useremails);
			
			String sql1 = new StringBuilder() 
				.append("UPDATE user2 SET ")
				.append("username=?, ")
				.append("userpassword=?, ")
				.append("userage=?, ")
				.append("useremail=? ")
				.append("WHERE userid=?")
				.toString();
				
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1,us.getUserName());
			pstmt1.setString(2,us.getUserPassword());
			pstmt1.setInt(3,us.getUserAge());
			pstmt1.setString(4,us.getUserEmail());
			pstmt1.setString(5,usid);
			pstmt1.executeUpdate();
			
		
			System.out.println("수정 완료하였습니다");
			System.out.println("변경된 이름: "+us.getUserName());
			System.out.println("변경된 비밀번호: "+us.getUserPassword());
			System.out.println("변경된 나이: "+us.getUserAge());
			System.out.println("변경된 이메일: "+us.getUserEmail());
			
			pstmt1.close();		
			System.out.println();
			System.out.println();
			
			mm.mainMn();
		}  catch(SQLException e) {
			e.printStackTrace();
		} 
	}

	
}
