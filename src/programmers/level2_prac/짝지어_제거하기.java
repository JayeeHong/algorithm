package programmers.level2_prac;

import java.util.Stack;

public class 짝지어_제거하기 {
    public static int solution(String s) {
        int answer = 1;

        Stack<Character> stk = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stk.isEmpty() && stk.peek() == c) {
                stk.pop();
            } else {
                stk.push(c);
            }
        }

        if(stk.size() > 0) answer = 0;

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("baabaa")); //1
        System.out.println(solution("cdcd")); //0
    }
}
