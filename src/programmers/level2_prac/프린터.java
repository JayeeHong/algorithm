package programmers.level2_prac;

import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {
    static class Printer {
        int priority;
        int location;

        public Printer(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Printer> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Printer(priorities[i], i));
        }

        int now = 0;
        while (!queue.isEmpty()) {
            Printer cur = queue.poll();
            boolean flag = false;
            for (Printer p : queue) {
                if (cur.priority < p.priority) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                queue.add(cur);
            } else {
                now++;
                if (cur.location == location) {
                    answer = now;
                    break;
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 3, 2}, 2)); //1
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0)); //5
    }
}
