package mis;
import java.util.*;
import java.sql.*;
public class SubMenu {
	Scanner scanner = new Scanner(System.in);
	Delete dl = new Delete();
	Update up = new Update();
	MainMenu mm = new MainMenu();
	User us = new User();
	List ls = new List();
	public void subMn() {
		System.out.println("메뉴를 고르세요");
		System.out.print("1.Update|2.Delete|3.List|4.메인으로 돌아가기|5.Exit");
		String cho = scanner.nextLine();
		switch (cho) {
        case "1":
        	System.out.println("게시글을 수정합니다");
        	up.updateB();
            break;
        case "2":
        	System.out.println("게시글을 삭제합니다");
        	dl.deleteB();
            break;
        case "3":
        	System.out.println("게시물 목록으로 돌아갑니다");
        	if(us.getUserId().equals("admin")) {ls.listB();}
        	//ls.listB();
            break;
        case "4":
        	System.out.println("메인으로 돌아갑니다");
        	mm.mainMn();
            break;
        case "5":
            System.out.println("프로그램을 종료합니다.");
            scanner.close();
            return;
        default:
            System.out.println("잘못된 선택입니다.");
            subMn();
    }
	}
}
