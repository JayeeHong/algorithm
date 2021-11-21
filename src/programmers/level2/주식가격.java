package programmers.level2;

import java.util.Arrays;
import java.util.Stack;

public class 주식가격 {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            Stack<Integer> s = new Stack<>();
            for (int j = i+1; j < prices.length; j++) {
                s.push(prices[i]);
                if (prices[i] > prices[j]) {
                    break;
                }
            }
            answer[i] = s.size();
        }

        answer[prices.length - 1] = 0;

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3}))); //{4,3,1,1,0}
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3, 1}))); //{5,4,1,2,1,0}
    }
}
