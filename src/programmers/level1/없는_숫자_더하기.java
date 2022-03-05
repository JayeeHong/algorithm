package programmers.level1;

import java.util.Arrays;

public class 없는_숫자_더하기 {
    public static int solution(int[] numbers) {
        int answer = 0;

        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        answer = 45 - sum;

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 6, 7, 8, 0})); //14
        System.out.println(solution(new int[]{5, 8, 4, 0, 6, 7, 9})); //6
    }
}
