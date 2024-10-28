package scmn;

public class Score {
    private String userId;
    private double subject1;
    private double subject2;
    private double subject3;
    private double subject4;
    private double averageScore;

    public Score(String userId, double subject1, double subject2, double subject3, double subject4, double averageScore) {
        this.userId = userId;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
        this.subject4 = subject4;
        this.averageScore = averageScore;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getSubject1() {
        return subject1;
    }

    public void setSubject1(double subject1) {
        this.subject1 = subject1;
    }

    public double getSubject2() {
        return subject2;
    }

    public void setSubject2(double subject2) {
        this.subject2 = subject2;
    }

    public double getSubject3() {
        return subject3;
    }

    public void setSubject3(double subject3) {
        this.subject3 = subject3;
    }

    public double getSubject4() {
        return subject4;
    }

    public void setSubject4(double subject4) {
        this.subject4 = subject4;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    @Override
    public String toString() {
        return "Score{" +
                "userId='" + userId + '\'' +
                ", subject1=" + subject1 +
                ", subject2=" + subject2 +
                ", subject3=" + subject3 +
                ", subject4=" + subject4 +
                ", averageScore=" + averageScore +
                '}';
    }
}