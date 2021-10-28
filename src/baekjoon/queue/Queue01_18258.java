package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [문제]
 * 정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
 *
 * 명령은 총 여섯 가지이다.
     * push X: 정수 X를 큐에 넣는 연산이다.
     * pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
     * size: 큐에 들어있는 정수의 개수를 출력한다.
     * empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
     * front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
     * back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 *
 * [입력]
 * 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 2,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.
 * 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.
 *
 * [출력]
 * 출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
 */

public class Queue01_18258 {
    private static int[] queue = new int[2000000]; //최대 2000000

    private static int size = 0;
    private static int front = 0;
    private static int back = 0;

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //명령의 수
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");

            switch(st.nextToken()) {
                case "push": push(Integer.parseInt(st.nextToken())); break;
                case "pop": pop(); break;
                case "size": size(); break;
                case "empty": empty(); break;
                case "front": front(); break;
                case "back": back(); break;
            }
        }

        System.out.println(sb);
    }

    private static void push(int X) {
        queue[back] = X;
        size++;
        back++;
    }

    private static void pop() {
        if(size == 0) {
            sb.append(-1 + "\n");
        } else {
            sb.append(queue[front] + "\n");
            size--;
            front++;
        }
    }

    private static void size() {
        sb.append(size + "\n");
    }

    private static void empty() {
        if(size == 0) {
            sb.append(1 + "\n");
        } else {
            sb.append(0 + "\n");
        }
    }

    private static void front() {
        if(size == 0) {
            sb.append(-1 + "\n");
        } else {
            sb.append(queue[front] + "\n");
        }
    }

    private static void back() {
        if(size == 0) {
            sb.append(-1 + "\n");
        } else {
            sb.append(queue[back-1] + "\n");
        }
    }
}