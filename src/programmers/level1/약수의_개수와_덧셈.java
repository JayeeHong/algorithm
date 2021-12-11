package programmers.level1;

public class 약수의_개수와_덧셈 {
    public static int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            double root = Math.sqrt(i);
            if (i % root > 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(13, 17)); //43
        System.out.println(solution(24, 27)); //52
    }
}
