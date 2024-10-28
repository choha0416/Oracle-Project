package scmn;

import java.util.Scanner;

public class StudentScManagement {
    private ScoreInsert si = new ScoreInsert(); // ScoreInsert 객체 초기화
    private ScoreUpdate su = new ScoreUpdate();
    private ScoreList sl = new ScoreList();
    private Scanner scanner = new Scanner(System.in);

    public void ssm() {
        System.out.print("1.성적 입력하기|2.성적 수정하기|3.석차 확인하기: ");
        String cho = scanner.nextLine();

        switch (cho) {
            case "1":
                System.out.println("성적 입력창으로 이동합니다");
                si.insertS(); // 메서드 호출
                break;
            case "2":
                System.out.println("성적 수정창으로 이동합니다");
                su.updateS();
                break;
            case "3":
                System.out.println("전체 석차를 확인합니다");
                sl.listS();
                break;
            default:
                ssm(); // 잘못된 입력 시 다시 호출
        }
    }
}