package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Stack06_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numArr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.empty() && numArr[stack.peek()] < numArr[i]) {
                numArr[stack.pop()] = numArr[i];
            }

            stack.push(i);



            //stack이 비어있으면 배열의 idx를 push
//            if (stack.empty()) {
//                stack.push(i);
//            } else {
//                //배열에서 현재 stack의 맨위 idx에 위치한 수와 현재 수를 비교
//                //현재 수가 작으면 stack에 idx를 push
//                if (numArr[stack.peek()] > numArr[i]) {
//                    stack.push(i);
//                } else { //현재 수가 크면 stack loop를 돌면서 해당 idx의 값이 작을 때 값을 바꿔줌
//                    while(true) {
//                        if (stack.empty()) { //stack이 비어 있으면 idx를 push하고 break
//                            stack.push(i);
//                            break;
//                        }
//                        if (numArr[stack.peek()] < numArr[i]) { //현재 수보다 작을 때만 현재 수로 배열의 값을 바꿈
//                            numArr[stack.pop()] = numArr[i];
//                        } else { //아니라면 stack에 push
//                            stack.push(i);
//                            break;
//                        }
//                    }
//                }
//            }
        }

        //배열의 길이만큼 다 돈 후에는
        //stack에 들어있는 idx에 위치한 값을 -1로 변경
        while(!stack.empty()) {
            numArr[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(numArr[i]).append(' ');
        }
        Arrays.toString(numArr);
        System.out.println(sb);
    }
}
