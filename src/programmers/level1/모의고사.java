package programmers.level1;

import java.util.Arrays;

public class 모의고사 {
    public static int[] solution(int[] answers) {
        int[] answer = {};

        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};

        int aCnt = 0;
        int bCnt = 0;
        int cCnt = 0;

        for(int i=0; i<answers.length; i++) {
            if(answers[i] == a[i%5]) {
                aCnt++;
            }
            if(answers[i] == b[i%8]) {
                bCnt++;
            }
            if(answers[i] == c[i%10]) {
                cCnt++;
            }
        }

        if (aCnt > bCnt) {
            if (aCnt > cCnt) {
                answer = new int[]{1};
            } else if (cCnt > aCnt) {
                answer = new int[]{3};
            } else {
                answer = new int[]{1, 3};
            }
        } else if (bCnt > cCnt) {
            if (bCnt > aCnt) {
                answer = new int[]{2};
            } else if (aCnt > bCnt) {
                answer = new int[]{1};
            } else {
                answer = new int[]{1, 2};
            }
        } else if (bCnt > aCnt) {
            if (bCnt > cCnt) {
                answer = new int[]{2};
            } else if (cCnt > bCnt) {
                answer = new int[]{3};
            } else {
                answer = new int[]{2, 3};
            }
        } else if (cCnt > bCnt) {
            if (cCnt > aCnt) {
                answer = new int[]{3};
            } else if (aCnt > cCnt) {
                answer = new int[]{1};
            } else {
                answer = new int[]{1, 3};
            }
        } else if (aCnt > cCnt) {
            if (aCnt > bCnt) {
                answer = new int[]{1};
            } else if (bCnt > aCnt) {
                answer = new int[]{2};
            } else {
                answer = new int[]{1, 2};
            }
        } else if (aCnt == bCnt && bCnt == cCnt) {
            answer = new int[]{1, 2, 3};
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5}))); //{1}
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 2, 4, 2}))); //{1,2,3}
    }
}
