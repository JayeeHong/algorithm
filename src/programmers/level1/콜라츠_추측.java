package programmers.level1;

public class 콜라츠_추측 {
    public static int solution(int num1) {
        long num = num1;

        for (int i = 0; i < 500; i++) {
            if (num == 1) return i;

            if (num % 2 == 0) num /= 2;
            else num = (num % 2 == 0) ? num / 2 : num * 3 + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(6)); //8
        System.out.println(solution(16)); //4
        System.out.println(solution(626331)); //-1
    }
}
