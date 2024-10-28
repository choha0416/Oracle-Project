package scmn;

import java.util.*;
import java.sql.*;
import java.io.*;

public class UserLogInOut {
	UserMenu um = new UserMenu();
	Scanner scanner = new Scanner(System.in);
	private String userid;
	private String userpassword;
	User us = new User(userid,userpassword);
	public void userLgI() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe",
					"system",
					"oracle"
			);
			
			System.out.print("아이디를 입력해 주세요");
			String usid = scanner.nextLine();
			us.setUserId(usid);

			System.out.print("비밀번호를 입력해 주세요");
			String uspw = scanner.nextLine();
			us.setUserPassword(uspw);
			
			String sql = ""+
			"SELECT userid, userpassword "+
			"FROM usersc ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				us.setUserId(rs.getString("userid"));
				us.setUserPassword(rs.getString("userpassword"));

				System.out.println(us);// 테이블 한행씩 읽어오기
				if(us.getUserId().equals(usid)) {
					System.out.println("1");
					
					break;
				}else {System.out.println("2");}
			}
			System.out.println(us.getUserId());
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		} 
		
		System.out.println(us.getUserId());
		um.userMn();
	}
	
	public void userLgO() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe",
					"system",
					"oracle"
			);
			
			//로그아웃관련 코드 입력할것
		}catch(SQLException e) {
			e.printStackTrace();
		} 
		
		System.out.println(us.getUserId());
		um.userMn();
	}

}
// 관리자와 학생은 학년으로 구분하고싶음학년은 1~4입력가능 or 정해놓은 5자리 수 하나만 입력가능
// 로그인할때 아이디와 비밀번호를 비교하고 그에따른 학년을 가져와서 1~4일경우 학생로그인
// 정해놓은 수 일경우 관리자 로그인
// 이곳에서 로그인하고 이동하는 모든페이지에서는 로그인된 id와 학년값을 가지고 이동 비밀번호는 필요x