package programmers.level1;

import java.util.Arrays;

public class 예산 {
    public static int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);
        int sum = 0;
        for (int i = 0; i < d.length; i++) {
            sum += d[i];
            if(sum > budget) break;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 2, 5, 4}, 9)); //3
        System.out.println(solution(new int[]{2, 2, 3, 3}, 10)); //4
    }
}
