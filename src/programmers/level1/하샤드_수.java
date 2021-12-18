package programmers.level1;

import java.util.ArrayList;

public class 하샤드_수 {
    public static boolean solution(int x) {
        boolean answer = true;

        int temp = x;
        ArrayList<Integer> xArr = new ArrayList<>();
        while (temp > 0) {
            xArr.add(temp % 10);
            temp /= 10;
        }

        int xSum = 0;
        for (int i : xArr) {
            xSum += i;
        }

        if (x % xSum == 0) {
            answer = true;
        } else {
            answer = false;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(10)); //true
        System.out.println(solution(12)); //true
        System.out.println(solution(11)); //false
        System.out.println(solution(13)); //false
    }
}
