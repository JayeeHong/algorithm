package programmers.level1;

import java.util.Arrays;

public class 체육복 {
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        //체육복을 잃어버린 학생이 여분을 가져왔을 때
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer++;
                }
            }
        }

        //여분 체육복을 가져온 학생이 빌려줄 수 있을 때
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j] - 1 || lost[i] == reserve[j] + 1) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer++;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2,4}, new int[]{1,3,5})); //5
        System.out.println(solution(5, new int[]{2,4}, new int[]{3})); //4
        System.out.println(solution(3, new int[]{3}, new int[]{1})); //2
    }
}
