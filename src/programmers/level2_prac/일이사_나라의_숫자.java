package programmers.level2_prac;

public class 일이사_나라의_숫자 {
    public static String solution(int n) {
        String answer = "";
        int share = n;
        int remainder = -1;

        while (share != 0) {
            remainder = share % 3;
            share = share / 3;

            if (remainder == 0) {
                answer = "4" + answer;
                share--;
            } else if (remainder == 1) {
                answer = "1" + answer;
            } else if (remainder == 2) {
                answer = "2" + answer;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(1)); //1
        System.out.println(solution(2)); //2
        System.out.println(solution(3)); //4
        System.out.println(solution(4)); //11
    }
}
