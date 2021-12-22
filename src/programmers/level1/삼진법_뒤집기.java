package programmers.level1;

public class 삼진법_뒤집기 {
    public static int solution(int n) {
        int answer = 0;

        String nStr = "";
        while (n > 0) {
            nStr = (n % 3) + nStr;
            n /= 3;
        }
        String[] nStrArr = nStr.split("");
        nStr = "";
        for (String s : nStrArr) {
            nStr = s + nStr;
        }

        answer = Integer.parseInt(nStr, 3);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(45)); //7
        System.out.println(solution(125)); //229
    }
}
