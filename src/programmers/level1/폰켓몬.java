package programmers.level1;

import java.util.ArrayList;

public class 폰켓몬 {
    public static int solution(int[] nums) {
        int answer = 0;

        ArrayList<Integer> num = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!num.contains(nums[i])) {
                num.add(nums[i]);
            }
        }

        answer = nums.length/2 > num.size() ? num.size() : nums.length/2;

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 1, 2, 3})); //2
        System.out.println(solution(new int[]{3, 3, 3, 2, 2, 4})); //3
        System.out.println(solution(new int[]{3, 3, 3, 2, 2, 2})); //2
    }
}
