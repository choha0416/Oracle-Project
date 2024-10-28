package scmn;

import java.sql.*;
import java.util.Scanner;

public class ScoreInsert {
    Scanner scanner = new Scanner(System.in);
    
    public void insertS() {
        Connection conn = null;

        try {
            // 데이터베이스 연결
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/xe",
                    "system",
                    "oracle"
            );

            // 유저 아이디와 비밀번호 입력받기
            System.out.print("교수 아이디를 입력하세요: ");
            String userId = scanner.nextLine();
            System.out.print("비밀번호를 입력하세요: ");
            String userPassword = scanner.nextLine();

            // 교수인지 확인
            if (isProfessor(userId, userPassword, conn)) {
                // 성적 입력받기
                System.out.print("과목 1 성적을 입력하세요: ");
                double subject1 = Double.parseDouble(scanner.nextLine());
                System.out.print("과목 2 성적을 입력하세요: ");
                double subject2 = Double.parseDouble(scanner.nextLine());
                System.out.print("과목 3 성적을 입력하세요: ");
                double subject3 = Double.parseDouble(scanner.nextLine());
                System.out.print("과목 4 성적을 입력하세요: ");
                double subject4 = Double.parseDouble(scanner.nextLine());

                // 평균 점수 계산
                double averageScore = (subject1 + subject2 + subject3 + subject4) / 4;

                // Score 객체 생성
                Score score = new Score(userId, subject1, subject2, subject3, subject4, averageScore);

                // 데이터베이스에 성적 저장
                String sql = "INSERT INTO score_table (userid, subject1, subject2, subject3, subject4, averageScore) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, score.getUserId());
                pstmt.setDouble(2, score.getSubject1());
                pstmt.setDouble(3, score.getSubject2());
                pstmt.setDouble(4, score.getSubject3());
                pstmt.setDouble(5, score.getSubject4());
                pstmt.setDouble(6, score.getAverageScore());

                pstmt.executeUpdate();
                pstmt.close();

                System.out.println("성적이 성공적으로 입력되었습니다.");
            } else {
                System.out.println("잘못된 교수 아이디 또는 비밀번호입니다.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean isProfessor(String userId, String userPassword, Connection conn) throws SQLException {
        String sql = "SELECT usergrade FROM usersc WHERE userid=? AND userpassword=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, userId);
        pstmt.setString(2, userPassword);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            int userGrade = rs.getInt("usergrade");
            return userGrade == 12345; // 학년이 12345일 경우 교수
        }
        return false;
    }
}