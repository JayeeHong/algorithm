package programmers.level1;

public class 음양_더하기 {
    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 7, 12}, new boolean[]{true, false, true})); //9
        System.out.println(solution(new int[]{1, 2, 3}, new boolean[]{false, false, true})); //0
    }
}
