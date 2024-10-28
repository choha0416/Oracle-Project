package scmn;

import java.io.*;
import java.sql.*;
import java.util.*;
public class UserLogin {
	UserMenu um = new UserMenu();
	Scanner scanner = new Scanner(System.in);
	private String userid;
	private String userpassword;
	
	User us = new User(userid,userpassword);
	
	public void userLg() {
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

				System.out.println(us);
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

}
