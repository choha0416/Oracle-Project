package scmn;
import java.util.*;
import java.sql.*;
public class UserMenu {
	
	private String userid;
	private String userpassword;	

	User us = new User(userid,userpassword);
	UserInsert usi = new UserInsert();
	UserUpdate usu = new UserUpdate();
	UserDelete usd = new UserDelete();
	Scanner scanner = new Scanner(System.in);
	public void userMn() {

		System.out.println(us.getUserId());
		
		System.out.print("1.회원가입|2.회원정보 수정|3.회원탈퇴");
		String cho = scanner.nextLine();
		
		switch(cho) {
		case "1" :
			System.out.println("회원가입으로 이동합니다");
			usi.insertU();
			break;
			
		case "2" :
			System.out.println("회원정보수정으로 이동합니다");
			usu.updateU();
			break;
			//교수 성적 입력 시스템으로 이동 메소드
		case "3" :
			System.out.println("회원탈퇴로 이동합니다");
			usd.deleteU();
			break;
			
		default:
			userMn();
		}
	}
}
