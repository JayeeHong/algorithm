package programmers.level1;

import java.util.Stack;

public class 크레인_인형뽑기_게임 {

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        int length = board[0].length;

        for(int i=0; i<moves.length; i++) {
            for(int j=0; j<length; j++) {
                int temp = board[j][moves[i]-1];

                if(temp != 0) {
                    if(!stack.empty()) {
                        if(temp == stack.peek()) {
                            stack.pop();
                            answer++;
                        } else {
                            stack.push(temp);
                        }
                    } else {
                        stack.push(temp);
                    }
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }
        }
        return answer * 2;
    }

    public static void main(String[] args) {
//        int[][] board = {
//                {0,0,0,0,0},
//                {0,0,1,0,3},
//                {0,2,5,0,1},
//                {4,2,4,4,2},
//                {3,5,1,3,1}
//        };

        int[][] board = {
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 2, 1, 0, 0},
                {0, 2, 1, 0, 0},
                {0, 2, 1, 0, 0}
        };

//        int[] moves = {1,5,3,5,1,2,1,4};
        int[] moves = {1, 2, 3, 3, 2, 3, 1};

        System.out.println(solution(board, moves));
    }
}
