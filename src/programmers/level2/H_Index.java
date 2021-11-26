package programmers.level2;

import java.util.Arrays;

public class H_Index {
    public static int solution(int[] citations) {
        int answer = 0;

        //오름차순 정렬 후 증가하는 인덱스 루프에서 현재 값이 남은 개수보다 크거나 같을 때의 남은 개수.
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length - i) {
                answer = citations.length - i;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 0, 6, 1, 5})); //3
    }
}
