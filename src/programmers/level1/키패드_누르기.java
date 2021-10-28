package programmers.level1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 키패드_누르기 {
    private static int[][] keypad = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {'*', 0, '#'}
    };

    public static String solution(int[] numbers, String hand) {
        int xPosLeft = 3;
        int yPosLeft = 0;
        int xPosRight = 3;
        int yPosRight = 2;
        int xPos = 0;
        int yPos = 0;

        String answer = "";

        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];

            xPos = xPos(n);
            yPos = yPos(n);

            if (IntStream.of(new int[]{1,4,7}).anyMatch(x -> x == n)) {
                answer += "L";
                xPosLeft = xPos;
                yPosLeft = yPos;
            } else if (IntStream.of(new int[]{3,6,9}).anyMatch(x -> x == n)) {
                answer += "R";
                xPosRight = xPos;
                yPosRight = yPos;
            } else {
                int leftDist = Math.abs(xPosLeft - xPos) + Math.abs(yPosLeft - yPos);
                int rightDist = Math.abs(xPosRight - xPos) + Math.abs(yPosRight - yPos);

                if (leftDist < rightDist) {
                    answer += "L";
                    xPosLeft = xPos;
                    yPosLeft = yPos;
                } else if (rightDist < leftDist) {
                    answer += "R";
                    xPosRight = xPos;
                    yPosRight = yPos;
                } else {
                    if ("right".equals(hand)) {
                        answer += "R";
                        xPosRight = xPos;
                        yPosRight = yPos;
                    } else {
                        answer += "L";
                        xPosLeft = xPos;
                        yPosLeft = yPos;
                    }
                }
            }
        }

        return answer;
    }

    public static int xPos(int number) {
        int xPos = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (number == keypad[i][j]) {
                    xPos = i;
                    break;
                }
            }
        }

        return xPos;
    }

    public static int yPos(int number) {
        int yPos = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (number == keypad[i][j]) {
                    yPos = j;
                    break;
                }
            }
        }

        return yPos;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right")); //LRLLLRLLRRL
        System.out.println(solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left")); //LRLLRRLLLRR
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right")); //LLRLLRLLRL
    }
}
