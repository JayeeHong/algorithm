package programmers.level1;

public class 짝수와_홀수 {
    public static String solution(int num) {
        String answer = "";

        if(num % 2 == 0) answer = "Even";
        else answer = "Odd";

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(3)); //Odd
        System.out.println(solution(4)); //Even
    }
}
