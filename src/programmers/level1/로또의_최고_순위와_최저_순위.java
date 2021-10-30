package programmers.level1;

import java.util.Arrays;

public class 로또의_최고_순위와_최저_순위 {
    public static int[] solution(int[] lottos, int[] win_nums) {
        //정렬
        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        //두개 배열이 같으면 최대, 최소 등수가 1등
        if (Arrays.equals(lottos, win_nums)) {
            return new int[]{1, 1};
        }

        int zeroCnt = 0; //lottos에서 0의 갯수
        int correctNumCnt = 0; //lottos에서 당첨 숫자 갯수
        for (int i = 0; i < lottos.length; i++) {
            //0의 갯수 카운트
            if(lottos[i] == 0) {
                zeroCnt++;
                continue;
            }

            //당첨 숫자 갯수 카운트
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    correctNumCnt++;
                    break;
                }
            }
        }

        //최대등수 : correctNumCnt + zeroCnt가 0일 때 무조건 1 리턴하게 지정
        //최소등수 : correctNumCnt가 0일 때 무조건 1 리턴하게 지정
        return new int[]{7 - Math.max(correctNumCnt + zeroCnt, 1), 7 - Math.max(correctNumCnt, 1)};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {44, 1, 0, 0, 31, 25}, new int[] {31, 10, 45, 1, 6, 19}))); //{3, 5}
        System.out.println(Arrays.toString(solution(new int[] {0, 0, 0, 0, 0, 0}, new int[] {38, 19, 20, 40, 15, 25}))); //{1, 6}
        System.out.println(Arrays.toString(solution(new int[] {45, 4, 35, 20, 3, 9}, new int[] {20, 9, 3, 45, 4, 35}))); //{1, 1}
    }
}
