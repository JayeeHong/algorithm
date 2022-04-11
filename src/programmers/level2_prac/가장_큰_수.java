package programmers.level2_prac;

import java.util.Arrays;
import java.util.Comparator;

public class 가장_큰_수 {

    public static String solution(int[] numbers) {
        String answer = "";
        String[] strArr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            strArr[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        if("0".equals(strArr[0])) {
            return "0";
        }

        for (int i = 0; i < strArr.length; i++) {
            answer += strArr[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{6, 10, 2})); //6210
        System.out.println(solution(new int[]{3, 30, 34, 5, 9})); //9534330
    }
}
