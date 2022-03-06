package programmers.level2;

import java.util.Arrays;
import java.util.Stack;

public class 수식_최대화 {

    private static Stack<Integer> stack = new Stack<>();

    public static long solution(String expression) {
        long answer = 0;
        char[] opArr = new char[expression.replaceAll("[0-9]", "").length()];
        int[] numArr = new int[opArr.length + 1];
        stack = new Stack<>();

        String num = "";
        int cnt = 0;
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (48 <= ch && ch <= 57) {
                num += Character.toString(ch);
            } else {
                opArr[cnt] = ch;
                numArr[cnt] = Integer.parseInt(num);
                num = "";
                cnt++;
            }
        }
        numArr[cnt] = Integer.parseInt(num);

        combination(opArr, numArr, new boolean[opArr.length+1], 0, opArr.length+1, opArr.length+1);

        System.out.println(stack);

        return answer;
    }

    static void combination(char[] opArr, int[] numArr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            stack.push(calculate(opArr, numArr));
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(opArr, numArr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    static int calculate(char[] opArr, int[] numArr) {
        int prevNum = numArr[0];
        System.out.println(Arrays.toString(opArr));
        System.out.println(Arrays.toString(numArr));
        for (int i = 1; i < numArr.length; i++) {
            if (opArr[i - 1] == '+') {
                prevNum += numArr[i];
            } else if (opArr[i - 1] == '-') {
                prevNum -= numArr[i];
            } else if (opArr[i - 1] == '*') {
                prevNum *= numArr[i];
            }
        }
        return prevNum;
    }

    public static void main(String[] args) {
        System.out.println(solution("100-200*300-500+20")); //60420
        System.out.println(solution("50*6-3*2")); //300
    }
}
