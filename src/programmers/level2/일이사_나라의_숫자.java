package programmers.level2;

public class 일이사_나라의_숫자 {
    public static String solution(int n) {
        String answer = "";

        String[] newWorldNum = new String[]{"4", "1", "2"};
        int q = n;

        while (q > 0) {
            int r = q % 3;
            q /= 3;

            if(r == 0) q--;

            answer = newWorldNum[r] + answer;
        }

        return answer;
    }


    public static void main(String[] args) {
//        System.out.println(solution(1)); //1
//        System.out.println(solution(2)); //2
        System.out.println(solution(3)); //4
//        System.out.println(solution(4)); //11
        System.out.println(solution(10)); //41
        System.out.println(solution(19)); //141
    }
}
