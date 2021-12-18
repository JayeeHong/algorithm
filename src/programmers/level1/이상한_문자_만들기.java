package programmers.level1;

public class 이상한_문자_만들기 {
    public static String solution(String s) {
        String answer = "";

        String[] sArr = s.split("");
        int i = 0;
        for (String str : sArr) {
            if(" ".equals(str)){
                i = 0;
                answer += str;
            } else {
                if (i % 2 == 0) {
                    answer += str.toUpperCase();
                } else {
                    answer += str.toLowerCase();
                }
                i++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
//        System.out.println(solution("try hello world")); //TrY HeLlO WoRlD
        System.out.println(solution(" hello")); // HeLlO
    }
}
