package programmers.level2;

import java.util.Arrays;

public class 행렬_테두리_회전하기 {
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int[][] rByC = new int[rows][columns];
        int num = 1;
        for (int i = 0; i < rByC.length; i++) {
            for (int j = 0; j < rByC[i].length; j++) {
                rByC[i][j] = num++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;

            int curNum = rByC[x1][y1];
            int nextNum = 0;
            int min = curNum;
            for (int j = y1; j <= y2; j++) {
                if(j+1 > y2) {
                    nextNum = rByC[x1+1][y2];
                    rByC[x1+1][y2] = curNum;
                } else {
                    nextNum = rByC[x1][j+1];
                    rByC[x1][j+1] = curNum;
                }

                if (min > nextNum) min = nextNum;

                curNum = nextNum;
            }

            for (int j = x1 + 1; j <= x2; j++) {
                if (j + 1 > x2) {
                    nextNum = rByC[x2][y2-1];
                    rByC[x2][y2-1] = curNum;
                } else {
                    nextNum = rByC[j+1][y2];
                    rByC[j+1][y2] = curNum;
                }

                if(min > nextNum) min = nextNum;

                curNum = nextNum;
            }

            for (int j = y2-1; j >= y1; j--) {
                if (j - 1 < y1) {
                    nextNum = rByC[x2-1][y1];
                    rByC[x2-1][y1] = curNum;
                } else {
                    nextNum = rByC[x2][j-1];
                    rByC[x2][j-1] = curNum;
                }

                if(min > nextNum) min = nextNum;

                curNum = nextNum;
            }

            for (int j = x2 - 1; j >= x1; j--) {
                if (j - 1 >= x1) {
                    nextNum = rByC[j - 1][y1];
                    rByC[j - 1][y1] = curNum;
                    if (min > nextNum) min = nextNum;
                    curNum = nextNum;
                }
            }

            answer[i] = min;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}}))); //[8, 10, 25]
        System.out.println(Arrays.toString(solution(3, 3, new int[][]{{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}}))); //[1, 1, 5, 3]
        System.out.println(Arrays.toString(solution(100, 97, new int[][]{{1, 1, 100, 97}}))); //[1]
    }
}
