package scmn;
import java.sql.*;
import java.util.*;
public class StudentScManagement {
	ScoreInsert si = new ScoreInsert();
	ScoreUpdate su = new ScoreUpdate();
	ScoreList sl = new ScoreList();
	Scanner scanner = new Scanner(System.in);
	public void ssm() {
		System.out.print("1.성적 입력하기|2.성적 수정하기|3.석차 확인하기");
		String cho = scanner.nextLine();
		
		switch(cho){
		case "1" :
			System.out.println("성적 입력창으로 이동합니다");
			si.insertS();
			break;
		case "2" :
			System.out.println("성적 수정창으로 이동합니다");
			su.updateS();
			break;
		case "3" :
			System.out.println("전체 석차를 확인합니다");
			sl.listS();
			break;
		default:
			ssm();
		}
	}
}
