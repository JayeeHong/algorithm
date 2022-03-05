package programmers.level2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 더_맵게 {
    static boolean checkScoville(PriorityQueue<Integer> heap, int K) {
        boolean isOK = true;
        for (int i : heap) {
            if(i < K && i != 0) {
                isOK = false;
                break;
            }
        }

        return isOK;
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i : scoville) {
            heap.add(i);
        }

        while (!checkScoville(heap, K)) {
            if(heap.size() == 1) {
                return -1;
            }
            answer++;
            heap.add(heap.poll() + heap.poll() * 2);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7)); //2
    }
}
