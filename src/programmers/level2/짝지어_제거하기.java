package programmers.level2;

import java.util.Stack;

public class 짝지어_제거하기 {
    public static int solution(String s) {
        int answer = 1;

        if(s.length() <= 1) return 0;

        Stack<String> stack = new Stack<>();
        for (String str : s.split("")) {
            if(!stack.isEmpty()) {
                if (!str.equals(stack.peek())) {
                    stack.push(str);
                } else {
                    stack.pop();
                }
            } else {
                stack.push(str);
            }
        }

        if(stack.size() > 0) answer = 0;

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("baabaa")); //1
        System.out.println(solution("cdcd")); //0
    }
}
