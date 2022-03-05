package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        //대기 중인 트럭 queue에 넣음
        Queue<Truck> queue_wait = new LinkedList<>();
        for (int i = 0; i < truck_weights.length; i++) {
            queue_wait.add(new Truck(truck_weights[i]));
        }

        //다리 위 트럭
        Queue<Truck> queue_bridge = new LinkedList<>();
        int weight_bridge = queue_wait.peek().weight;
        queue_bridge.offer(queue_wait.poll());
        while (!queue_bridge.isEmpty()) {
            answer++;

            //다리 위 트럭 위치 이동
            for (Truck truck : queue_bridge) {
                truck.position++;
            }

            //다리 위 트럭이 다 이동했으면 queue에서 뺌
            if (queue_bridge.peek().position > bridge_length) {
                weight_bridge -= queue_bridge.poll().weight;
            }

            //새 트럭 queue에 넣음
            if(!queue_wait.isEmpty() && weight_bridge + queue_wait.peek().weight <= weight) {
                weight_bridge += queue_wait.peek().weight;
                queue_wait.peek().position++;
                queue_bridge.add(queue_wait.poll());
            }
        }

        return answer;
    }

    static class Truck {
        int position;
        int weight;

        public Truck(int weight) {
            this.position = 0;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[]{7, 4, 5, 6})); //8
        System.out.println(solution(100, 100, new int[]{10})); //101
        System.out.println(solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10})); //110
    }
}
