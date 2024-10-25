package mis;
import java.util.*;

import java.sql.*;
public class Loginmenu {
	Scanner scanner = new Scanner(System.in);
	MainMenu mm = new MainMenu();
	UserInsert ui = new UserInsert();
	UserUpdate up = new UserUpdate();
	UserDelete ud = new UserDelete();
	UserLogin lom = new UserLogin();
	public void loginMn() {
		System.out.println("메뉴를 고르세요");
		System.out.print("1.로그인하기|2.회원가입|3.정보수정|4.회원탈퇴|5.메인으로 돌아가기");
		System.out.println();
		String cho = scanner.nextLine();
		switch (cho) {
        case "1":
        	System.out.println();
        	System.out.println("로그인페이지로 이동합니다");
        	lom.userlg(); 
            break;
        case "2":
        	System.out.println();
        	System.out.println("회원가입으로 이동합니다");
        	ui.insertU();
            break;
        case "3":
        	System.out.println();
        	System.out.println("회원정보를 수정합니다");
        	up.userUp();
            break;
        case "4":
        	System.out.println();
        	System.out.println("회원 탈퇴하기");
        	ud.userDl();
            break;    
        case "5":
        	System.out.println();
        	System.out.println("메인으로 돌아갑니다.");
        	mm.mainMn();
        	break;  
        default: 
        	loginMn();
        	break;  
    }
	}
}
