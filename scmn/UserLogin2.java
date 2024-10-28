package scmn;

import java.io.*;
import java.sql.*;
import java.util.*;
public class UserLogin2 {
	Scanner scanner = new Scanner(System.in);
	private String userid;
	private String userpassword;
	User us = new User(userid,userpassword);
	private String username;
	private String usergrade;
	private String userage;
	private User user;
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
			"SELECT userid, userpassword, username, usergrade, userage "+
			"FROM usersc "+
			"WHERE userid=? AND userpassword=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, userpassword);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new User(
						rs.getString(userid),
						rs.getString(userpassword),
						rs.getString(username),
						rs.getInt(usergrade),
						rs.getInt(userage)
						);
				
			}
			System.out.println(us);
			
			
		
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		} 
	}
}
