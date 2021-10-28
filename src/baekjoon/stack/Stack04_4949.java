package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack04_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str;
        while(true) {
            str = br.readLine();
            if (".".equals(str)) {
                break;
            }

            sb.append(checkBal(str)).append("\n");
        }

        System.out.println(sb);
    }

    public static String checkBal(String s) {
        Stack<String> stack = new Stack<String>();
        String[] sArr = s.split("");

        for (String str : sArr) {
            if ("(".equals(str) || "[".equals(str)) {
                stack.push(str);
            } else if (")".equals(str)) {
                if (stack.empty() || !"(".equals(stack.peek())) {
                    return "no";
                } else {
                    stack.pop();
                }
            } else if ("]".equals(str)) {
                if (stack.empty() || !"[".equals(stack.peek())) {
                    return "no";
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.empty()) {
            return "yes";
        }

        return "no";
    }
}
