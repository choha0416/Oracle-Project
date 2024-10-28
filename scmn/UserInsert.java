package scmn;

import java.util.*;
import java.sql.*;
import java.io.*;

public class UserInsert {
	
	private String userid;
	private String userpassword;
	Scanner scanner = new Scanner(System.in);
	User us = new User(userid,userpassword);

	public void insertU() {
		Connection conn = null;
		System.out.print("아이디를 입력해 주세요");
		String usid = scanner.nextLine();
		us.setUserId(usid);

		
		System.out.print("비밀번호를 입력해 주세요");
		String uspw = scanner.nextLine();
		us.setUserPassword(uspw);

		
		System.out.print("이름을 입력해 주세요");
		String usnm = scanner.nextLine();
		us.setUserName(usnm);

		
		System.out.println("나이를 입력해 주세요");
		int usag = Integer.parseInt(scanner.nextLine());
		us.setUserAge(usag);

		
		System.out.println("학년을 입력해 주세요");
		int usgd = Integer.parseInt(scanner.nextLine());
		us.setUserGrade(usgd);
		
		System.out.println("등록이 완료되었습니다");
		System.out.println();
		System.out.println("\t\t"+"아이디:"+us.getUserId());
		System.out.println("\t\t"+"이름:"+us.getUserName());
		System.out.println("\t\t"+"학년:"+us.getUserGrade());

		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe",
					"system",
					"oracle"
			);
			
			String sql  = ""+
					"INSERT INTO usersc(userid, username, userpassword, userage, usergrade) "+
					"VALUES(?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,us.getUserId());
			pstmt.setString(2,us.getUserName());
			pstmt.setString(3,us.getUserPassword());
			pstmt.setInt(4,us.getUserAge());
			pstmt.setInt(5,us.getUserGrade());
					
					
					pstmt.executeUpdate();
					
					pstmt.close();
					System.out.println();
					System.out.println();
					
		}  catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
}