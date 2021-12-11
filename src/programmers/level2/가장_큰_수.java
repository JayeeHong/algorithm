package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

public class 가장_큰_수 {
    public static String solution(int[] numbers) {
        String[] result = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = Integer.toString(numbers[i]);
        }

        //정렬
        Arrays.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        if("0".equals(result[0])) {
            return "0";
        }

        String answer = "";
        for (int i = 0; i < result.length; i++) {
            answer += result[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{6, 10, 2})); //6210
        System.out.println(solution(new int[]{3, 30, 34, 5, 9})); //9534330
    }
}
