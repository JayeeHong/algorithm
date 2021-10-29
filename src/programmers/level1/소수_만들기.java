package programmers.level1;

public class 소수_만들기 {
    public static int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (isSosu(nums[i], nums[j], nums[k])) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    static boolean isSosu(int a, int b, int c) {
        int n = a+b+c;

        if(n==2) return false;

        for (int i = 2; i <= n/2+1; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4})); //1
        System.out.println(solution(new int[]{1, 2, 7, 6, 4})); //4
    }
}
