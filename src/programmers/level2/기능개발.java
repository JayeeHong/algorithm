package programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 기능개발 {
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        //남은 작업의 개수
        int[] todos = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            todos[i] = 100 - progresses[i];
        }

        //작업을 하는데 걸리는 일수
        Stack<Integer> stack = new Stack<>();
        for (int i = todos.length - 1; i >= 0; i--) {
            stack.push(todos[i] / speeds[i] + (todos[i] % speeds[i] != 0 ? 1 : 0));
        }

        Queue<Integer> queue = new LinkedList<>();
        while (!stack.isEmpty()) {
            int pop = stack.pop();
            int cnt = 1;

            while (!stack.isEmpty() && pop >= stack.peek()) {
                cnt++;
                stack.pop();
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
        System.out.println(Arrays.toString(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}))); //{2,1}
        System.out.println(Arrays.toString(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}))); //{1,3,2}
        System.out.println(Arrays.toString(solution(
                new int[]{99, 1, 99, 1}, new int[]{1, 1, 1, 1}
        ))); //{1,3}
    }
}
