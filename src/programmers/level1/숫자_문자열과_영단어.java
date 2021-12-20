package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class 숫자_문자열과_영단어 {
    public static int solution(String s) {
        int answer = 0;
        String answerStr = "";

        Map<String, Integer> numEngMap = new HashMap<>();
        numEngMap.put("zero", 0);
        numEngMap.put("one", 1);
        numEngMap.put("two", 2);
        numEngMap.put("three", 3);
        numEngMap.put("four", 4);
        numEngMap.put("five", 5);
        numEngMap.put("six", 6);
        numEngMap.put("seven", 7);
        numEngMap.put("eight", 8);
        numEngMap.put("nine", 9);

        String[] sArr = s.split("");
        String temp = "";
        for (String str : sArr) {
            if (!isNumeric(str)) {
                temp += str;
                if (numEngMap.get(temp) != null) {
                    answerStr += numEngMap.get(temp);
                    temp = "";
                }
            } else {
                answerStr += str;
            }
        }
        
        answer = Integer.parseInt(answerStr);
        return answer;
    }

    public static boolean isNumeric(String s) {
        return s.replaceAll("[+-]?\\d+", "").equals("") ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(solution("one4seveneight")); //1478
        System.out.println(solution("23four5six7")); //234567
        System.out.println(solution("2three45sixseven")); //234567
        System.out.println(solution("123")); //123
    }
}
