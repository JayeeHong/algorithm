package programmers.level1;

public class 수박수박수박수박수박수 {
    public static String solution(int n) {
        String answer = "";

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                answer += "수";
            } else {
                answer += "박";
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(3)); //수박수
        System.out.println(solution(4)); //수박수박
    }
}
