package programmers.level2_prac;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 기능개발 {
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int[] rest_prog = new int[progresses.length]; //남은일
        for (int i = 0; i < progresses.length; i++) {
            int temp = 100-progresses[i];
            rest_prog[i] = temp / speeds[i] + (temp % speeds[i] > 0 ? 1 : 0);
        }

        Stack<Integer> stk = new Stack<>();
        for (int i = rest_prog.length - 1; i >= 0; i--) {
            stk.push(rest_prog[i]);
        }

        Queue<Integer> queue = new LinkedList<>();
        while (!stk.isEmpty()) {
            int pop = stk.pop();
            int cnt = 1;
            while (!stk.isEmpty() && pop >= stk.peek()) {
                stk.pop();
                cnt++;
            }

            queue.add(cnt);
        }

        answer = new int[queue.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = queue.remove();
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new int[]{93, 30, 55}, new int[]{1, 30, 5}
                ))); // {2,1}
        System.out.println(Arrays.toString(solution(
                new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}
        ))); // {1,3,2}
        System.out.println(Arrays.toString(solution(
                new int[]{99, 99, 99}, new int[]{1, 1, 1}
        ))); // {3}
        System.out.println(Arrays.toString(solution(
                new int[]{99, 1, 99, 1}, new int[]{1, 1, 1, 1}
        ))); // {1, 3}
    }
}
