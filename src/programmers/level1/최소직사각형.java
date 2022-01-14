package programmers.level1;

import java.util.Arrays;

public class 최소직사각형 {
    public static int solution(int[][] sizes) {
        int answer = 0;

        //정렬
        for (int i = 0; i < sizes.length; i++) {
            Arrays.sort(sizes[i]);
        }

        int[] smallArr = new int[sizes.length];
        int[] bigArr = new int[sizes.length];
        for (int i = 0; i < sizes.length; i++) {
            smallArr[i] = sizes[i][0];
            bigArr[i] = sizes[i][1];
        }

        Arrays.sort(smallArr);
        Arrays.sort(bigArr);

        answer = smallArr[smallArr.length-1] * bigArr[bigArr.length-1];

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
        System.out.println(solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}));
        System.out.println(solution(new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}));
    }
}
