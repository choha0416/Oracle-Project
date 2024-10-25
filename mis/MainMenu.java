package mis;
import java.util.*;

import java.sql.*;
public class MainMenu {
	Scanner scanner = new Scanner(System.in);
	public void mainMn() {
		Create ct = new Create();
		SubMenu sm = new SubMenu();	
		Clear cl = new Clear();
		Loginmenu lm = new Loginmenu();
		System.out.println("메뉴를 고르세요");
		System.out.print("1.Create|2.Read|3.Clear|4.로그인메뉴|5.Exit");
		String cho = scanner.nextLine();
		switch (cho) {
        case "1":
        	System.out.println("게시글을 작성합니다");
        	ct.createB();
            break;
        case "2":
        	System.out.println("서브메뉴로 이동합니다");
        	sm.subMn();
            break;
        case "3":
        	System.out.println("모든 게시글을 삭제합니다");
        	cl.clearB();
            break;
        case "4":
        	System.out.println("로그인메뉴");
        	lm.loginMn();
            break;    
        case "5":
        	System.out.println("프로그램을 종료합니다.");
            scanner.close();
            return;
        default:
            System.out.println("잘못된 선택입니다.");
            mainMn();
    }
	}
}
