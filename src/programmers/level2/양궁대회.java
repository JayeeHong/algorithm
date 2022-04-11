package programmers.level2;

import java.util.Arrays;

public class 양궁대회 {
    public static int[] solution(int n, int[] info) {
        int[] answer = new int[11];

        int apeachTot = 0; //어피치 총 점수
        for (int i = 0; i < 11; i++) {
            int score = 11 - i - 1;
            apeachTot += score * info[i];
        }

        int lionShootCnt = 0; //라이언이 쏜 화살 수 카운트



        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}))); //[0,2,2,0,1,0,0,0,0,0,0]
        System.out.println(Arrays.toString(solution(1, new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}))); //[-1]
        System.out.println(Arrays.toString(solution(9, new int[]{0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1}))); //[1,1,2,0,1,2,2,0,0,0,0]
        System.out.println(Arrays.toString(solution(10, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3}))); //[1,1,1,1,1,1,1,1,0,0,2]
    }
}
