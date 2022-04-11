package dev_matching_상반기;

import java.util.Arrays;
import java.util.Stack;

public class Task2 {
    public static int solution(String[] grid) {
        int answer = -1;

        if (grid.length == 1) {
            String[] gridArr = grid[0].split("");
            int cnt = 0;
            for (int i = 0; i < gridArr.length; i++) {
                if ("?".equals(gridArr[i])) {
                    cnt++;
                }
            }

            return cnt * 3;
        }

        String[][] gridArr = new String[grid.length][grid[0].length()];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                gridArr[i][j] = Character.toString(grid[i].charAt(j));
            }
//            System.out.println(Arrays.toString(gridArr[i]));
        }

        for (int i = 0; i < gridArr.length; i++) {
            for (int j = 0; j < gridArr[i].length; j++) {
                if ("?".equals(gridArr[i][j])) {
                    if (i == 0) {
                        if (j == 0) {
                            if(!"?".equals(gridArr[i+1][j])) {
                                gridArr[i][j] = gridArr[i+1][j];
                            } else if(!"?".equals(gridArr[i][j+1])) {
                                gridArr[i][j] = gridArr[i][j+1];
                            }
                        } else if (j < gridArr[i].length-1) {
                            if(!"?".equals(gridArr[i-1][j])) {
                                gridArr[i][j] = gridArr[i-1][j];
                            } else if(!"?".equals(gridArr[i+1][j])) {
                                gridArr[i][j] = gridArr[i+1][j];
                            } else if(!"?".equals(gridArr[i][j+1])) {
                                gridArr[i][j] = gridArr[i][j+1];
                            }
                        } else {

                        }
                    }


//                    for (int k = 0; k <= 2; k++) {
//                        gridArr[i][j] = Character.toString(97 + k); //a,b,c
//                        if (i == 0) {
//                            if (j == 0) {
//
//                            }
//                        }
//                    }
                }
            }
            System.out.println(Arrays.toString(gridArr[i]));
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"??b", "abc", "cc?"}));
        System.out.println(solution(new String[]{"abcabcab","????????"}));
    }
}
