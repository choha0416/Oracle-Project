package scmn;
import java.sql.*;
import java.util.*;
public class MainMenu {
	Scanner scanner = new Scanner(System.in);
	public void mainMn() {
		System.out.println("1.학생 성적확인|2.교수 성적입력");
		String cho = scanner.nextLine();
		
		switch(cho) {
		case "1" :
			System.out.println("학생 성적 확인시스템으로 이동합니다");
			//로그인 이동 메소드
		case "2" :
			System.out.println("교수 성적입력시스템으로 이동합니다");
			//교수 성적 입력 시스템으로 이동 메소드
		}
	}
}
