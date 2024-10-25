package mis;
import java.sql.*;
import java.util.*;
public class UserLogin {
	Scanner scanner = new Scanner(System.in);
	User us = new User();
	MainMenu mm = new MainMenu();
	
	public void userlg() {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe",
					"system",
					"oracle"
			);
			System.out.print("아이디를 입력하세요: ");		
			String uslgid = scanner.nextLine();
			us.setUserId(uslgid);
			
			System.out.print("\n"+"비밀번호를 입력하세요: ");	
			String userlgpw = scanner.nextLine();
			us.setUserPassword(userlgpw);
			String sql = "{? = call user_login2(?, ?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			//값 지정 및 리턴 타입 지정
			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.setString(2, us.getUserId());
			cstmt.setString(3, us.getUserPassword());
			
			//함수 실행 및 리턴값 얻기
			cstmt.execute();
			int result = cstmt.getInt(1);
			
			cstmt.close();
			//로그인 경과 스위치 익스프레션 사용
			String message = switch(result) {
			case 0 -> "로그인 성공";
			case 1 -> "비밀번호가 틀림";
			default -> "아이디가 존재하지 않음";
			};
			System.out.println(message);
			
			mm.mainMn();
		}  catch(SQLException e) {
			e.printStackTrace();
		} 
	}

	
}
