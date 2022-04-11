package programmers.level2_prac;

import java.util.PriorityQueue;

public class 더_맵게 {
    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int s : scoville) {
            queue.add(s);
        }

        while (!checkScoville(queue, K)) {
            if (queue.size() == 1) {
                answer = -1;
                break;
            }

            queue.add(queue.poll() + queue.poll() * 2);
            answer++;
        }

        return answer;
    }

    public static boolean checkScoville(PriorityQueue<Integer> queue, int K) {
        for(int q : queue) {
            if (q < K) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7)); //2
    }
}
