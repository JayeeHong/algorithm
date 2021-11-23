package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;

public class 두_개_뽑아서_더하기 {
    public static int[] solution(int[] numbers) {
        ArrayList<Integer> numbersList = new ArrayList<>();
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if(!numbersList.contains(numbers[i] + numbers[j])) {
                    numbersList.add(numbers[i] + numbers[j]);
                }
            }
        }

        int[] answer = new int[numbersList.size()];
        for (int i = 0; i < numbersList.size(); i++) {
            answer[i] = numbersList.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 3, 4, 1}))); //[2,3,4,5,6,7]
        System.out.println(Arrays.toString(solution(new int[]{5, 0, 2, 7}))); //[2,5,7,9,12]
    }
}
